package com.tiantian.distribute.common;

import com.tiantian.distribute.common.config.ApplicationConfig;
import com.tiantian.distribute.common.filter.BaseFilter;
import com.tiantian.distribute.common.service.TestService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class App {
	private Server server=null;
	private ApplicationConfig applicationConfig=null;
	private ServletHolder jerseyServlet=null;
	private ServletContextHandler context=null;
	protected ApplicationContext applicationContext=null;

	private int port;

	public App(int port,String mapper,String actionPath){
		this.port=port;
		applicationConfig = new ApplicationConfig(actionPath);
		init();
	}

	public void init(){
		if(server!=null&&(server.isStarting()||server.isStarting())){
			return;
		}
		if(jerseyServlet==null){
			jerseyServlet = new ServletHolder(new ServletContainer(applicationConfig));
		}
		if(context==null){
			context = new ServletContextHandler();
			context.setContextPath("/");
			context.addServlet(jerseyServlet, "/rest/*");

			context.addEventListener(new ContextLoaderListener());
			context.addEventListener(new RequestContextListener());
			context.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
			//context.setInitParameter("contextConfigLocation", SpringJavaConfiguration.class.getName());

			ServletHandler handler = new ServletHandler();
			//ServletHolder sh = new ServletHolder(new MyServlet());
			//context.addServlet(sh, "/*");

			//FilterHolder fh = handler.addFilterWithMapping(BaseFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));

			BaseFilter filter=new BaseFilter(this);
			FilterHolder fh=new FilterHolder(filter);
			handler.addFilterWithMapping(fh, "/*", EnumSet.of(DispatcherType.REQUEST));
			//fh.setInitParameter("initParamKey", "InitParamValue");
			context.addFilter(fh, "/*", EnumSet.of(DispatcherType.REQUEST));
		}
		server = new Server(port);
		server.setHandler(context);
	}

	public final void setApplicationContext(ApplicationContext applicationContext ){
		this.applicationContext=applicationContext;
	}
	public void start(){
		try {
			if(server==null||server.isStopped()){
				init();
			}
			server.start();
			initialize();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop(){
		try {
			if(server!=null&&server.isStarting()){
				server.stop();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void restart(){
		stop();
		init();
		start();
	}
	protected void register(){
		TestService testService=(TestService)applicationContext.getBean("testService");
		testService.insert(100);
	}

	protected void initialize(){
		//register();
	}

	public static void main(String[] args) throws Exception {
		String actionPath="com.tiantian.distribute.common.action";
		App a=new App(8080,"",actionPath);
		a.start();
	}


}
