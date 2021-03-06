/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.itemprocessor;

import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import jp.co.jeu.jbatch.entity.JbatchTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author soyou
 */
@Named
@Dependent
public class MyItemProcessor implements ItemProcessor {
    
    private static final Logger logger = LogManager.getLogger(MyItemProcessor.class.getSimpleName());
    
    @PostConstruct
    public void init() {
        System.out.println("ItemProcessor init.");
    }
    
    @Override
    public Object processItem(Object item) throws Exception {
        String line = (String) item;
        logger.info("Processor processItem : " + line);
        String[] values = line.split(",");
        String name = values[1];
        JbatchTest test = new JbatchTest(BigDecimal.valueOf(Integer.parseInt(values[0])), name);
        return test;
    }
}
