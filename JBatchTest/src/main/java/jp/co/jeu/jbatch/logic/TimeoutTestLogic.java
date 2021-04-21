/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.logic;

import javax.enterprise.context.Dependent;
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
//    @Inject
//    private StubRestClient stubClient;

    public int exec() {
        logger.info(":::::::: Request delay to Stub Server");
//        int status = stubClient.get(path);
//        logger.info(":::::::: HTTP Status {}", status);
        return 0;
    }

}
