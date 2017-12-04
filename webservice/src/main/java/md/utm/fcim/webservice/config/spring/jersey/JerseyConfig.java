package md.utm.fcim.webservice.config.spring.jersey;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import md.utm.fcim.common.error.config.DuplicateEntityExceptionMapper;
import md.utm.fcim.common.error.config.EntityNotFoundExceptionMapper;
import md.utm.fcim.common.error.config.IllegalArgumentExceptionMapper;
import md.utm.fcim.common.error.config.WrongUrlIdExceptionMapper;
import md.utm.fcim.webservice.controller.impl.AuthorControllerImpl;
import md.utm.fcim.webservice.controller.impl.BookControllerImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    @Value("${spring.jersey.application-path:/}")
    private String apiPath;

    public JerseyConfig() {
        registerEndpoints();
        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/api");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());

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
