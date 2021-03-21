package jp.co.jeu.jbatch.resources;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.jbatch.annotation.TraceLogger;
import jp.co.jeu.jbatch.beans.MyInterface;
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

    @GET
    @Path("/jbatch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        // Xml
//        XmlReader xmlReader =  new XmlReader();

        logger.info(SystemSettingsManager.get("URL"));

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

        return Response
                .ok("ping")
                .build();
    }
}
