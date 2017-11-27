package md.utm.fcim.webservice.controller;

import md.utm.fcim.webservice.constants.OffsetLimitHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/author")
public interface AuthorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    @GET
    @Path("/pagination")
    @Produces(MediaType.APPLICATION_JSON)
    Response findPage(@QueryParam("page") @DefaultValue(OffsetLimitHelper.PAGE) Integer page,
                     @QueryParam("size") @DefaultValue(OffsetLimitHelper.SIZE) Integer size);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") Long id);
}
