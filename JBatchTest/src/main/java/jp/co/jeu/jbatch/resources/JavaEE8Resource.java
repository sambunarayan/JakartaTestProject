package jp.co.jeu.jbatch.resources;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("/batch-start")
public class JavaEE8Resource {
    
    @GET
    public Response ping(){
        // ジョブの起動
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long executionId = jobOperator.start("my-batch-job", null);

        return Response
                .ok("ping")
                .build();
    }
}
