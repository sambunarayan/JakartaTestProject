/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.resources;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.jbatch.logic.TimeoutTestLogic;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author soyou
 */
@Path("/timeout")
@RequestScoped
public class TimeoutResource {

    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(TimeoutResource.class.getSimpleName());
    @Inject
    private TimeoutTestLogic logic;

    @Path("/exec")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response process() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> logic.exec());
        try {
            future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimeoutResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(TimeoutResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            logger.error(" ********* TimeoutException *********");
            return Response.serverError()
                    .build();
        }
        return Response.ok()
                .build();
    }
}
