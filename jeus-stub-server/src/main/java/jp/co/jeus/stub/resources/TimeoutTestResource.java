/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.stub.resources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author soyou
 */
@Path("timeout")
@RequestScoped
public class TimeoutTestResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response respond(String payload) {
        System.out.println(payload);
        return Response
                .ok()
                .build();
    }
}
