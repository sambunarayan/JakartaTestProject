package jp.co.jeu.jsftestapp.resources;

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
    public Response ping(){
//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
//        session.invalidate();
        
        return Response
                .ok("ping")
                .build();
    }
}
