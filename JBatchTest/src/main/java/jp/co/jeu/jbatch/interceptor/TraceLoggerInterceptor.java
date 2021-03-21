/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import jp.co.jeu.jbatch.annotation.TraceLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author soyou
 */
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@TraceLogger
public class TraceLoggerInterceptor {

    private static final Logger logger = LogManager.getLogger(TraceLoggerInterceptor.class.getSimpleName());

    @AroundInvoke
    public Object trace(InvocationContext ic) throws Exception {
        logger.info(":::::: Trace Start ::::::");
        logger.debug("Target --> " + ic.getTarget());
        logger.debug("Target method --> " + ic.getMethod());
        logger.debug("Target Param --> " + ic.getParameters());
        logger.debug("Target Timer --> " + ic.getTimer());
        Object res = null;
        try {
            res = ic.proceed();
        } catch (Exception e) {
            logger.error(e);
        }
        logger.info(":::::: Trace End ::::::");
        return res;
    }
}
