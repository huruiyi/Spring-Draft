package com.vk.liyj.service;

import java.util.List;
import java.util.Map;

import com.vk.liyj.model.ConsultConfigArea;
import com.vk.liyj.model.ConsultContent;

public interface ICommonService {
    List<ConsultContent> queryContent(Map map);

    public List<ConsultConfigArea> qryArea(Map param);

    int saveArea(ConsultConfigArea area);

    int saveAreaToBase(ConsultConfigArea area);

    public List<ConsultConfigArea> qryAreaFromBase(Map param);

}
