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
import jp.co.jeu.webappondocker.constants.ProcStatus;
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
        final long tId = Thread.currentThread().getId();
        ResponseTimer.regist(Thread.currentThread(), Long.parseLong(SystemSettingsManager.get(SystemKeys.RESPONSE_TIMEOUT_MILLISECOND)));
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            ResponseTimer.regist(Thread.currentThread(), ResponseTimer.getRemaingTime(tId));
            ProcStatus result = null;
            try {
                System.out.println(" :::::::: before requestToStub ---> " + ResponseTimer.getRemaingTime(Thread.currentThread()));
                Thread.sleep(15000);
                result = logic.requestToStub();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException occured in requestToStub");
//                Thread.currentThread().interrupt();
            } finally {
                ResponseTimer.remove(Thread.currentThread());
            }
            return result;
        });
        try {
            System.out.println("Wailt Future " + Thread.currentThread().getId());
            future.get(Long.parseLong(SystemSettingsManager.get(SystemKeys.RESPONSE_TIMEOUT_MILLISECOND)), TimeUnit.MILLISECONDS);
            System.out.println("Release Future " + Thread.currentThread().getId());
            ResponseTimer.showMap();
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
