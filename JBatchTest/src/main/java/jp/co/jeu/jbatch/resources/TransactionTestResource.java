/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import jp.co.jeu.jbatch.exception.JeusRunTimeException;
import jp.co.jeu.jbatch.logic.TransactionTestLogic;

/**
 *
 * @author soyou
 */
@Path("/tx")
@RequestScoped
public class TransactionTestResource {

    @Inject
    private TransactionTestLogic logic;

    @GET
    @Path("/exec")
    public Response process() {
        exec();
        return Response
                .ok()
                .build();
    }

    @Transactional(TxType.REQUIRES_NEW)
    private Response exec() {
        try {
            long[] id = {33277L, 46943};
            for (long i : id) {
                logic.exec(i);
            }
        } catch (JeusRunTimeException e) {

        }
        return Response
                .ok()
                .build();
    }

}
