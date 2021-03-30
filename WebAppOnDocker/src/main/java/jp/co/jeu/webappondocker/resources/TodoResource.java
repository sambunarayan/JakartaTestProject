package jp.co.jeu.webappondocker.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("javaee8")
public class TodoResource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }

    @GET
    public Response findTodo() {

        return Response
                .ok()
                .build();
    }
}
