package jp.co.jeu.jbatch.resources;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.jbatch.annotation.TraceLogger;
import jp.co.jeu.jbatch.beans.MyInterface;
import jp.co.jeu.jbatch.logic.EJBTransactionTestLogic;
import jp.co.jeu.jbatch.system.SystemSettingsManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author
 */
@Path("/batch-start")
@TraceLogger
public class JBatchResource {
    
    private static final Logger logger = LogManager.getLogger(JBatchResource.class.getSimpleName());
    
    @Inject
    private MyInterface myInter;
    @Inject
    private EJBTransactionTestLogic txLogic;
    
    @GET
    @Path("/jbatch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        // Xml
//        XmlReader xmlReader =  new XmlReader();
        logger.info(SystemSettingsManager.get("URL"));
        System.setProperty("serviceName", "JBatchTest");
        // ジョブの起動
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long executionId = jobOperator.start("my-batch-job", null);
        
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("/bean")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response testBean() {
        
        logger.info("MyInterface class name : " + myInter.getClass().getSimpleName());
        for (int i = 0; i < 5; i++) {
            try {
                txLogic.execute();
            } catch (Exception e) {
            }
        }
        
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update/{id}")
    public Response update(@PathParam("id") int id) {
        try {
            logger.info(" ::::::::: txLogic  ----> " + txLogic);
            txLogic.update(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response
                .ok()
                .build();
    }
    
}
