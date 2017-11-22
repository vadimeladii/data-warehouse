package md.utm.fcim.webservice.config.spring.jersey;

import md.utm.fcim.webservice.controller.impl.UserControllerImpl;
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
        register(UserControllerImpl.class);
    }

}
