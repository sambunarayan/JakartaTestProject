package jp.co.jeu.webappondocker;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import jp.co.jeu.webappondocker.resources.ConnectionPoolTestResource;
import jp.co.jeu.webappondocker.resources.ProducerTestResource;
import jp.co.jeu.webappondocker.resources.TestTimeoutAppResource;
import jp.co.jeu.webappondocker.resources.TodoResource;

/**
 * Configures JAX-RS for the application.
 *
 * @author Juneau
 */
@ApplicationPath("test-service1")
public class TestService1Configuration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ProducerTestResource.class);
        resources.add(TestTimeoutAppResource.class);
        resources.add(TodoResource.class);
        resources.add(ConnectionPoolTestResource.class);
        return resources;
    }
}
