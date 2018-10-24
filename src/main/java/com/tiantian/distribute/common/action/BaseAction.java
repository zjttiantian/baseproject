package com.tiantian.distribute.common.action;

import com.tiantian.distribute.common.bean.Test;
import com.tiantian.distribute.common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class BaseAction {
   
    @Autowired
    protected TestService testService;

}