/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.resourcelocaltest.annotation.interceptor;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.persistence.EntityManager;
import jp.co.jeu.resourcelocaltest.annotation.LocalTransactionScoped;

/**
 *
 * @author soyou
 */
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@LocalTransactionScoped
public class TransactionInterceptor {

    @Inject
    private EntityManager em;

    @AroundInvoke
    public void transactionMange() {

    }
}
