package com.tiantian.distribute.common.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;


public class ApplicationConfig extends ResourceConfig {

    public static final StringBuffer DbDriver=new StringBuffer();
    public static final StringBuffer DbUrl=new StringBuffer();
    public static final StringBuffer DbUserName=new StringBuffer();
    public static final StringBuffer DbPassword=new StringBuffer();
    public static final StringBuffer MapperPath=new StringBuffer();
    public static final StringBuffer MapperPachage=new StringBuffer();
    
    public ApplicationConfig(String actionPath) {
    	packages(actionPath);
        register(JacksonFeature.class);
        //register(RequestContextFilter.class);  // Though it might be needed. Guess not
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
    }
}
