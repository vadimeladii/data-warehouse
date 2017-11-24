package md.utm.fcim.webservice.controller;

import md.utm.fcim.webservice.view.BookView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public interface BookController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<BookView> findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    BookView findById(@PathParam("id") Long id);
}
