/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.logic;

import javax.enterprise.context.Dependent;
import jp.co.jeu.webappondocker.constants.ProcStatus;
import jp.co.jeus.common.lib.timer.ResponseTimer;

/**
 *
 * @author soyou
 */
@Dependent
public class TimeoutTestLogic {

    public ProcStatus requestToStub() {
        ResponseTimer.showMap();
        System.out.println(" :::::::: requestToStub Thread ID ---> " + Thread.currentThread().getId());
        System.out.println(" :::::::: requestToStub remaining ---> " + ResponseTimer.getRemaingTime(Thread.currentThread()));
        return ProcStatus.OK;
    }
}
