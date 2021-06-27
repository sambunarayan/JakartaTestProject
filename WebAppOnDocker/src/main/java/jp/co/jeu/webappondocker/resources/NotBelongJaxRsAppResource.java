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
 * It is a resource class that does not belong to any Application class.<br>
 * For jax-rs application test.
 *
 * @author soyou
 */
@Path("not-belong")
@RequestScoped
public class NotBelongJaxRsAppResource {

    @GET
    public Response respond() {
        return Response
                .ok("success")
                .build();
    }
}
