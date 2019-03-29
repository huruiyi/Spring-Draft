package com.vk.liyj;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.pagehelper.PageHelper;
import com.vk.liyj.mapper.CommonMapper;
import com.vk.liyj.model.ConsultConfigArea;
import com.vk.liyj.service.ICommonService;
import com.vk.liyj.service.RedisService;

@RunWith(SpringJUnit4ClassRunner.class)
//SpringJUnit支持，由此引入Spring-Test框架支持！ 
//@SpringApplicationConfiguration  1.4后被替换为@SpringBootTest
@SpringBootTest(classes = SpringBootSampleApplication.class)
//指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class SpringBootJUnitTest {

    public static final Logger logger = LoggerFactory.getLogger(SpringBootJUnitTest.class);

    @Autowired
    CommonMapper mapper;

    @Autowired
    ICommonService service;

    @Autowired
    RedisService redisService;

    @Test
    public void testMyBatis() {
        PageHelper.startPage(1, 5);
        System.out.println(mapper.queryContent(new HashMap()));
    }

    @Test
    public void testDS2() {
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("555");
        area.setAreaName("liyj");
        area.setState(0);
        //        PageHelper.startPage(1, 1);
        System.out.println(service.saveArea(area));
    }

    @Test
    public void testDS1() {
        List<ConsultConfigArea> areas = service.qryArea(new HashMap());

        for (ConsultConfigArea area : areas) {
            logger.info(area.getAreaCode() + " " + area.getAreaName() + " "
                    + area.getState());
        }
    }

    @Test
    public void testDefaultDS() {
        List<ConsultConfigArea> areas = service.qryAreaFromBase(new HashMap());

        for (ConsultConfigArea area : areas) {
            logger.info(area.getAreaCode() + " " + area.getAreaName() + " "
                    + area.getState());
        }
    }

    @Test
    public void testDefaultDSAdd() {
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("HHVIP");
        area.setAreaName("basenameVIP");
        area.setState(0);
        //        PageHelper.startPage(1, 1);
        System.out.println(service.saveAreaToBase(area));
    }

    @Test
    public void cacheRedis() {
        redisService.cacheObject("test测试缓存数据");
    }

    @Test
    public void testRedis() {
        if (redisService.findByKey("test测试") != null)
            logger.info(redisService.findByKey("test测试").toString());
    }

}
