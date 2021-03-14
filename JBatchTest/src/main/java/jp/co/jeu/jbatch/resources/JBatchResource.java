package jp.co.jeu.jbatch.resources;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.jbatch.annotation.TraceLogger;
import jp.co.jeu.jbatch.system.SystemSettingsManager;

/**
 *
 * @author
 */
@Path("/batch-start")
@TraceLogger
public class JBatchResource {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        // Xml
//        XmlReader xmlReader =  new XmlReader();

        System.out.println(SystemSettingsManager.get("URL"));

        // ジョブの起動
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long executionId = jobOperator.start("my-batch-job", null);

        return Response
                .ok("ping")
                .build();
    }
}
