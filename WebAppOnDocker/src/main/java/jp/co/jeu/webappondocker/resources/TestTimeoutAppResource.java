/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.resources;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import jp.co.jeu.webappondocker.logic.TimeoutTestLogic;
import jp.co.jeus.common.lib.constants.SystemKeys;
import jp.co.jeus.common.lib.system.SystemSettingsManager;
import jp.co.jeus.common.lib.timer.ResponseTimer;

/**
 *
 * @author soyou
 */
@Path("/timeout")
@RequestScoped
public class TestTimeoutAppResource {

    @Inject
    private TimeoutTestLogic logic;

    @GET
    public Response doTest() {
        ResponseTimer.regist(Thread.currentThread(), Long.parseLong(SystemSettingsManager.get(SystemKeys.RESPONSE_TIMEOUT_SECOND)));
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            return logic.requestToStub();
        });
        try {
            future.get(Long.parseLong(SystemSettingsManager.get(SystemKeys.RESPONSE_TIMEOUT_SECOND)), TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestTimeoutAppResource.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        } catch (ExecutionException ex) {
            Logger.getLogger(TestTimeoutAppResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(TestTimeoutAppResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok()
                .build();
    }
}
