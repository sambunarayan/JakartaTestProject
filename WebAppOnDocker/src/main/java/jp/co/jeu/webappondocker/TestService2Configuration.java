package jp.co.jeu.webappondocker;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import jp.co.jeu.webappondocker.resources.JaxRsAppTestResource;

/**
 * Configures JAX-RS for the application.
 *
 * @author Juneau
 */
@ApplicationPath("test-service2")
public class TestService2Configuration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(JaxRsAppTestResource.class);
        return resources;
    }
}
