/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.logic;

import javax.enterprise.context.Dependent;
import jp.co.jeu.webappondocker.constants.ProcStatus;

/**
 *
 * @author soyou
 */
@Dependent
public class TimeoutTestLogic {

    public ProcStatus requestToStub() {

        return ProcStatus.OK;
    }
}
