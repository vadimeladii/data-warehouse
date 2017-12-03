package md.utm.fcim.common.error.config;

import md.utm.fcim.common.error.DuplicateEntityException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class DuplicateEntityExceptionMapper
        implements ExceptionMapper<DuplicateEntityException> {

    public Response toResponse(DuplicateEntityException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessageException())
                .build();
    }
}
