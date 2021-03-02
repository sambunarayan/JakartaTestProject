package jp.co.jeu.resourcelocaltest.resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("javaee8")
public class JavaEE8Resource {

    @GET
    public Response ping() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jp.co.jeu_ResourceLocalTest_war_1.0.0PU");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("SELECT * FROM TEST");
        query.getResultList().stream().forEach(o -> {
            Object[] objs = (Object[]) o;
            System.out.println(objs[0] + "," + objs[1]);
        });
        return Response
                .ok("ping")
                .build();
    }
}
