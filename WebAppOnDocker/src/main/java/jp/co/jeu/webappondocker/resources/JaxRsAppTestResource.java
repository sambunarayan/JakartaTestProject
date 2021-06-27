/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.resources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author soyou
 */
@Path("test2")
@RequestScoped
public class JaxRsAppTestResource {
    
    @GET
    public Response respond() {
        return Response
                .ok("success")
                .build();
    }
}
