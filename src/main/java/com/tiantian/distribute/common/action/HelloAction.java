package com.tiantian.distribute.common.action;

import com.tiantian.distribute.common.bean.Test;
import com.tiantian.distribute.common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloAction extends BaseAction{
   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Test getGreeting(@PathParam("id") Integer id) throws Exception {
        testService.addTest(id);
        return testService.queryById(id);
    }
    
 
}