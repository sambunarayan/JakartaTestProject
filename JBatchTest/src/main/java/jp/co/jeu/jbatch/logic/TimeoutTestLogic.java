/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.logic;

import java.math.BigInteger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import jp.co.jeu.jbatch.dao.UserInfoDao;
import jp.co.jeu.jbatch.entity.UserInfo;
import jp.co.jeu.jbatch.rest.StubRestClient;
import jp.co.jeu.jbatch.utils.UserInfoIdCeator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author soyou
 */
@Dependent
public class TimeoutTestLogic {
    
    private static final String path = "/rest/delay";
    
    private Logger logger = LogManager.getLogger(TimeoutTestLogic.class.getSimpleName());
    @Inject
    private StubRestClient stubClient;
    @Inject
    private UserInfoDao dao;
    
    public int exec() {
        logger.info(":::::::: Request delay to Stub Server");
        int status = stubClient.get(path);
        logger.info(":::::::: HTTP Status {}", status);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UserInfoIdCeator.create());
        userInfo.setUserName("TestUser");
        userInfo.setAge(BigInteger.valueOf(((long) (Math.random() * 100))));
        dao.regist(userInfo);
        return status;
    }
    
}
