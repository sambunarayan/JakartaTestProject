package jp.co.jeu.webappondocker.resources;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("javaee8")
public class TodoResource {

    @PersistenceContext(name = "jp.co.jeu_WebAppOnDocker_war_1.0.0PU")
    private EntityManager em;

    @GET
    public Response ping() {
        
        return Response
                .ok("ping")
                .build();
    }

    @Path("/find/todo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTodo() {

        Query query = em.createNamedQuery("TodoList.findAll");
        List list = query.getResultList();

        return Response
                .ok(list)
                .build();
    }
}
