/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import jp.co.jeu.webappondocker.logic.ProducerTestLogic;

/**
 *
 * @author soyou
 */
@Path("producer")
@RequestScoped
@Transactional
public class ProducerTestResource {

    @Inject
    private ProducerTestLogic testLogic;

    @GET
    @Path("test")
    public Response respond() {

        System.out.println(" :::::::: TestLogic ---> " + testLogic.hashCode());
        System.out.println(" :::::::: EntityManager in TestLogic ---> " + testLogic.getEntityManager().hashCode());
        return Response
                .ok()
                .build();
    }
}
