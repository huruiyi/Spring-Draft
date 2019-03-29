package com.vk.liyj.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 启动加载数据
 *
 * @author liyj23
 */
@Component
@Order(value = 1)
public class StartUp1 implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StartUp1.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info(this.getClass().getName() + "启动加载数据1" + args);
    }

}
