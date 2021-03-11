package jp.co.jeu.jbatch.resources;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import jp.co.jeu.jbatch.xml.XmlReader;

/**
 *
 * @author 
 */
@Path("/batch-start")
public class JavaEE8Resource {
    
    @GET
    public Response ping(){
        // Xml
        XmlReader xmlReader =  new XmlReader();
        
        // ジョブの起動
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long executionId = jobOperator.start("my-batch-job", null);

        return Response
                .ok("ping")
                .build();
    }
}
