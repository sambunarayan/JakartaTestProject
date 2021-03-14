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

/**
 *
 * @author soyou
 */
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@TraceLogger
public class TraceLoggerInterceptor {
    
    @AroundInvoke
    public Object trace(InvocationContext ic) throws Exception {
        System.out.println(":::::: Trace Start ::::::");
        System.out.println("Target --> " + ic.getTarget());
        System.out.println("Target method --> " + ic.getMethod());
        System.out.println("Target Param --> " + ic.getParameters());
        System.out.println("Target Timer --> " + ic.getTimer());
        Object result = ic.proceed();
        System.out.println(":::::: Trace End ::::::");
        return result;
    }
}
