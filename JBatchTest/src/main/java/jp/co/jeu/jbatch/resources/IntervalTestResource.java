/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.resources;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
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
@Path("/interval")
@RequestScoped
public class IntervalTestResource {

    @Path("/exec")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response process() throws Exception {
        Thread th = new Thread(() -> {
            System.out.println(LocalDateTime.now() + "int the hread -> " + Thread.currentThread().getId());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(LocalDateTime.now() + "in interruptedException -> " + Thread.currentThread().getId());
                Thread.currentThread().interrupt();
                System.out.println(LocalDateTime.now() + "in interruptedException after interrupted -> " + Thread.currentThread().getId());
            }
        });
        System.out.println(LocalDateTime.now() + "before start Thread -> " + Thread.currentThread().getId());
        th.start();
        System.out.println(LocalDateTime.now() + "After start Thread -> " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(3);
        th.interrupt();
        System.out.println(LocalDateTime.now() + "After Inturrupted Thread -> " + Thread.currentThread().getId());

        return Response
                .ok()
                .build();
    }
}
