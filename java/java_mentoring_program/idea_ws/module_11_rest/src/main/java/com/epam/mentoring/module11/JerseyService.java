package com.epam.mentoring.module11;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// JAX-RS is a specification for REST services
// Jersey is a realization of JAX-RS

@Path("/message")
public class JerseyService {

    @GET
    public String getMsg() {
        return "Hello World from Jersey!!!";
    }
}
