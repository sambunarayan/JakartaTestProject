/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.resources;

import java.sql.Connection;
import javax.enterprise.context.RequestScoped;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author soyou
 */
@Path("connection-test")
@RequestScoped
public class ConnectionPoolTestResource {

    @PersistenceContext(name = "jp.co.jeu_WebAppOnDocker_war_1.0.0PU")
    private EntityManager em;

//    @Resource(mappedName = "jdbc:/payara_test_db")
//    private DataSource datasource;
    @GET
    public Response respond() {
        try {
            Query query = em.createNamedQuery("TodoList.findAll");
            return Response.ok(query.getResultList())
                    .build();
        } catch (Exception e) {
            return Response
                    .ok(e.getMessage())
                    .build();
        }
//        Session session = (Session) em.getDelegate();
//        Connection conn = em.unwrap(Connection.class);
//        Connection conn = em.unwrap(Session.class).connection();
//        return Response
//                .ok("success")
//                .build();
    }
}
