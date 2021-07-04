/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.dao;

import javax.persistence.EntityManager;

/**
 *
 * @author soyou
 */
public abstract class AbstractDao {

    protected abstract EntityManager getEntityManager();
}
