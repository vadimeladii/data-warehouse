package md.utm.fcim.webservice.controller;

import md.utm.fcim.webservice.view.UserView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public interface UserController {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    UserView test();
}
