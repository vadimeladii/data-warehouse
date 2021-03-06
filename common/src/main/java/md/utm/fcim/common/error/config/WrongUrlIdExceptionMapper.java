package md.utm.fcim.common.error.config;

import md.utm.fcim.common.error.WrongUrlIdException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WrongUrlIdExceptionMapper
        implements ExceptionMapper<WrongUrlIdException> {

    public Response toResponse(WrongUrlIdException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessageException())
                .build();
    }
}