package com.upaio;

import org.jboss.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @GET
    public Response hello() {
        LOG.debug("Hi from debug");
        LOG.info("Hi from info");
        return Response.ok("Hello from RESTEasy Reactive").build();
    }
}