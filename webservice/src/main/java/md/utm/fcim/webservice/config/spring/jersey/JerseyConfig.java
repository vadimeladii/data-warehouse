package md.utm.fcim.webservice.config.spring.jersey;

import md.utm.fcim.common.error.config.DuplicateEntityExceptionMapper;
import md.utm.fcim.common.error.config.EntityNotFoundExceptionMapper;
import md.utm.fcim.common.error.config.IllegalArgumentExceptionMapper;
import md.utm.fcim.common.error.config.WrongUrlIdExceptionMapper;
import md.utm.fcim.webservice.controller.impl.AuthorControllerImpl;
import md.utm.fcim.webservice.controller.impl.BookControllerImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(WadlResource.class);
        register(BookControllerImpl.class);
        register(AuthorControllerImpl.class);
        register(EntityNotFoundExceptionMapper.class);
        register(WrongUrlIdExceptionMapper.class);
        register(DuplicateEntityExceptionMapper.class);
        register(IllegalArgumentExceptionMapper.class);
    }

}
