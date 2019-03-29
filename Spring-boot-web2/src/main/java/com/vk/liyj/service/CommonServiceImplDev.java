package com.vk.liyj.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.vk.liyj.model.ConsultConfigArea;
import com.vk.liyj.model.ConsultContent;


@Service
@Profile("dev")
public class CommonServiceImplDev implements ICommonService {
    private static final Logger logger = LoggerFactory.getLogger(CommonServiceImplDev.class);

    @Override
    public List<ConsultContent> queryContent(Map map) {
        logger.info("我是dev环境！");
        return null;
    }

    @Override
    public List<ConsultConfigArea> qryArea(Map param) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int saveArea(ConsultConfigArea area) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int saveAreaToBase(ConsultConfigArea area) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ConsultConfigArea> qryAreaFromBase(Map param) {
        // TODO Auto-generated method stub
        return null;
    }

}
