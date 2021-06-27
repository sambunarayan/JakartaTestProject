/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.dao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import jp.co.jeu.jbatch.entity.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author soyou
 */
@Transactional
@Dependent
public class UserInfoDao {
    
    private Logger logger = LogManager.getLogger(UserInfoDao.class.getSimpleName());
    @Inject
    private EntityManager em;
    
    public void regist(UserInfo userInfo) {
        em.persist(userInfo);
        logger.info("============ Success Regist userinfo =============");
    }
}
