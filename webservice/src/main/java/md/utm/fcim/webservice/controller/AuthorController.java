package md.utm.fcim.webservice.controller;

import io.swagger.annotations.Api;
import md.utm.fcim.webservice.constants.OffsetLimitHelper;
import md.utm.fcim.webservice.view.AuthorView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/author")
@Api(value = "AUTHOR Controller Resource Endpoint")
public interface AuthorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll();

    @GET
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    Response findPage(@QueryParam("page") @DefaultValue(OffsetLimitHelper.PAGE) Integer page,
                     @QueryParam("size") @DefaultValue(OffsetLimitHelper.SIZE) Integer size);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findById(@PathParam("id") Long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(AuthorView authorView);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response edit(AuthorView authorView);
}
