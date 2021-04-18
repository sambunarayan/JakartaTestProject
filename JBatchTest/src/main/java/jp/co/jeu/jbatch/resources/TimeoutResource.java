/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.resources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author soyou
 */
@Path("/timeout")
@RequestScoped
public class TimeoutResource {

    @Path("/exec")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response process() {
        
//        CompletableFuture.supplyAsync()
        
        return Response.ok()
                .build();
    }
}
