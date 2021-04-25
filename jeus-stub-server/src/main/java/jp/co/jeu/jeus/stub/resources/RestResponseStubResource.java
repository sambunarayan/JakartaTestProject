/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jeus.stub.resources;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.jeus.stub.tool.ResponseXmlReader;

/**
 *
 * @author soyou
 */
@Path("/rest")
public class RestResponseStubResource {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doResponse(String reqData) {
        Map<String, String> response = ResponseXmlReader.get("D:\\Temp\\ResponseData.xml");
        System.out.println(response.get("description"));
        System.out.println(response);
        return Response
                .ok()
                .build();
    }

    @GET
    @Path("/delay")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doDelay(@QueryParam("env") String env) {
        Map<String, String> delayConfig = null; 
        switch (env) {
            case "local":
                delayConfig = ResponseXmlReader.getFromResouce("/DelayConfig.xml");
                break;
            case "docker":
                delayConfig = ResponseXmlReader.get("/opt/payara/data/DelayConfig.xml");
                break;
        }
        try {
            Thread.sleep(Long.parseLong(delayConfig.get("sleep")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Response.ok().build();
    }
}
