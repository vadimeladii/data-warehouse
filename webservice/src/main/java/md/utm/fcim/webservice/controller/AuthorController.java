package md.utm.fcim.webservice.controller;

import md.utm.fcim.webservice.view.AuthorView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/author")
public interface AuthorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<AuthorView> findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    AuthorView findById(@PathParam("id") Long id);
}
