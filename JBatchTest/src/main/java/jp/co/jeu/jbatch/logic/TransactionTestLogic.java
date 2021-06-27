/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.logic;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import jp.co.jeu.jbatch.dao.TransactionTestDao;
import jp.co.jeu.jbatch.exception.JeusRunTimeException;

/**
 *
 * @author soyou
 */
@Dependent
@Transactional
public class TransactionTestLogic {

    @Inject
    private TransactionTestDao dao;

    @Transactional(rollbackOn = {JeusRunTimeException.class, Exception.class})
    public void exec(long id) {
        String name = "Tx" + ((int) (Math.random() * 100));
        dao.updateName(id, name);
        if (id == 46943) {
            throw new JeusRunTimeException();
        }
    }
}
