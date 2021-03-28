/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.resources;

import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.jbatch.beans.DependentTestBean;
import jp.co.jeu.jbatch.beans.SessionTestBean;
import jp.co.jeu.jbatch.beans.StatefulTestBean;
import jp.co.jeu.jbatch.beans.StatelessTestBean;
import jp.co.jeu.jbatch.logic.TransactionTestLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author soyou
 */
@Path("/req-pool/")
@RequestScoped
public class ReqScopedPoolTestResource {

    private static final Logger logger = LogManager.getLogger(JBatchResource.class.getSimpleName());

    @Inject
    private TransactionTestLogic txLogic;
    @Inject
    private DependentTestBean depTestBean;
    @Inject
    private StatefulTestBean fulTestBean;
    @Inject
    private StatelessTestBean lessTestBean;
    @Inject
    private SessionTestBean sessionTestBean;
    
    private AtomicInteger in = new AtomicInteger();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/bean")
    public Response testBean() {
        try {
            logger.info(System.lineSeparator());
            logger.info(" --------------------------------------------------------- ");
            logger.info(" ::::::::: DependentTestBean  ----> " + depTestBean);
            logger.info("        data  ----> " + depTestBean.getId());
            logger.info(" ::::::::: StatefulTestBean  ----> " + fulTestBean);
            logger.info("        data  ----> " + fulTestBean.getId());
            logger.info(" ::::::::: StatelessTestBean  ----> " + lessTestBean);
            logger.info("        data  ----> " + lessTestBean.getId());
            logger.info(" ::::::::: SessionTestBean  ----> " + sessionTestBean);
            logger.info("        data  ----> " + sessionTestBean.getId());
            
            depTestBean.setId(in.getAndIncrement());
            fulTestBean.setId(in.getAndIncrement());
            lessTestBean.setId(in.getAndIncrement());
            sessionTestBean.setId(in.getAndIncrement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response
                .ok()
                .build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/dbCon")
    public Response dbCon() {
        try {
            logger.info(" ::::::::: txLogic  ----> " + txLogic);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
            txLogic.update(38344);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response
                .ok()
                .build();
    }
}
