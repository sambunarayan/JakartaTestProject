/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.stub.resources;

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
            System.out.println(LocalDateTime.now() + "in the thread -> " + Thread.currentThread().getId());
            try {
                System.out.println(LocalDateTime.now() + "in the thread -> " + Thread.interrupted());
                TimeUnit.SECONDS.sleep(10);
                System.out.println(LocalDateTime.now() + "in the thread end -> " + Thread.interrupted());
            } catch (InterruptedException e) {
                System.out.println(LocalDateTime.now() + "in interruptedException -> " + Thread.currentThread().getId());
                System.out.println(LocalDateTime.now() + "in interruptedException -> " + Thread.interrupted());
                Thread.currentThread().interrupt();
                System.out.println(LocalDateTime.now() + "in interruptedException after interrupted -> " + Thread.currentThread().getId());
                System.out.println(LocalDateTime.now() + "in interruptedException after interrupted -> " + Thread.interrupted());
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

    @Path("/sleep")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testTimeSleep1() throws Exception {
        Thread th = new Thread(() -> {
            int c = 0;
            while (c++ < 7) {
                try {
                    System.out.println(LocalDateTime.now() + "in the thread" + c + " -> " + Thread.currentThread().getId());
                    System.out.println(LocalDateTime.now() + "in the thread end" + c + " -> " + Thread.interrupted());
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println(LocalDateTime.now() + "in interruptedException" + c + " -> " + Thread.currentThread().getId());
//                    Thread.currentThread().interrupt();
                    System.out.println(LocalDateTime.now() + "in interruptedException" + c + " -> " + Thread.interrupted());
                }
            }
            System.out.println("::::::::::::::::::::: END ::::::::::::::::::::::::::::::::");
            System.out.println(LocalDateTime.now() + "------------------->  -> " + Thread.interrupted());
        });
        System.out.println(LocalDateTime.now() + "before start Thread -> " + Thread.currentThread().getId());
        th.start();
        System.out.println(LocalDateTime.now() + "After start Thread -> " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(3);
        th.interrupt();
        TimeUnit.SECONDS.sleep(3);
        th.interrupt();
        TimeUnit.SECONDS.sleep(10);
        System.out.println(LocalDateTime.now() + "After Inturrupted Thread -> " + Thread.currentThread().getId());

        return Response
                .ok()
                .build();
    }

    @Path("/sleep2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testTimeSleep2() throws Exception {
        Thread th = new Thread(() -> {
            int c = 0;
            while (c++ < 7) {
                try {
                    System.out.println(LocalDateTime.now() + "in the thread" + c + " -> " + Thread.currentThread().getId());
                    System.out.println(LocalDateTime.now() + "in the thread end" + c + " -> " + Thread.interrupted());
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println(LocalDateTime.now() + "in interruptedException" + c + " -> " + Thread.currentThread().getId());
                    Thread.currentThread().interrupt();
                    System.out.println(LocalDateTime.now() + "in interruptedException" + c + " -> " + Thread.interrupted());
                }
            }
            System.out.println("::::::::::::::::::::: END ::::::::::::::::::::::::::::::::");
            System.out.println(LocalDateTime.now() + "------------------->  -> " + Thread.interrupted());
        });
        System.out.println(LocalDateTime.now() + "before start Thread -> " + Thread.currentThread().getId());
        th.start();
        System.out.println(LocalDateTime.now() + "After start Thread -> " + Thread.currentThread().getId());
        TimeUnit.SECONDS.sleep(3);
        th.interrupt();
        TimeUnit.SECONDS.sleep(3);
        th.interrupt();
        TimeUnit.SECONDS.sleep(10);
        System.out.println(LocalDateTime.now() + "After Inturrupted Thread -> " + Thread.currentThread().getId());

        return Response
                .ok()
                .build();
    }
}
