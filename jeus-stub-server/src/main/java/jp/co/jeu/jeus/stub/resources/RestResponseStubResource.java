/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jeus.stub.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.jeus.stub.tool.ResponseXmlReader;
import jp.co.jeu.jeus.stub.xml.ResponseDatas;

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
        ResponseDatas response = ResponseXmlReader.get("D:\\Temp\\ResponseData.xml");
        System.out.println(response.getDescription());
        System.out.println(response.getData());
        return Response
                .ok()
                .build();
    }
}
