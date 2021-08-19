/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jp.co.jeus.common.lib.dao.AbstractDao;

/**
 *
 * @author soyou
 */
public class AbstractWebAppDao extends AbstractDao {

    @PersistenceContext(name = "jp.co.jeu_WebAppOnDocker_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
