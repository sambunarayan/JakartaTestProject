package jp.co.jeu.jsftest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author
 */
@Path("javaee8")
public class JavaEE8Resource {

    @GET
    @Produces(MediaType.APPLICATION_XHTML_XML)
    public String ping() {
        return "response";
    }
}
