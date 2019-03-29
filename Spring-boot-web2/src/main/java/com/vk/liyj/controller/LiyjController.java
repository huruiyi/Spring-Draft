package com.vk.liyj.controller;

import com.vk.liyj.model.ConsultContent;
import com.vk.liyj.service.ICommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class LiyjController {

    private static final Logger logger = LoggerFactory.getLogger(LiyjController.class);

    @Value("${application.value:Hello liyj}")
    private String value = "";

    @Autowired
    private ICommonService commonService;

    @RequestMapping("/login")
    public String login(String value) {
        return "my name is liyj";
    }

    //请求/或/index时都会进入此方法
    @RequestMapping(value = {"/", "index"})
    public String index(Map<String, Object> model) {
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp
        model.put("time", new Date());
        model.put("message", this.value);
        logger.debug("请求index方法");
        return "index";
    }

    @RequestMapping("/page")
    public ModelAndView page() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("time", new Date());
        view.addObject("message", this.value);
        return view;
    }

    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map) {
        map.put("name", "[Angel -- 守护天使]");
        map.put("gender", 1);//gender:性别，1：男；0：女；

        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "jack");
        friend.put("age", 30);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "jeff");
        friend.put("age", 36);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
    }

    @RequestMapping("/queryContent")
    public @ResponseBody
    List<ConsultContent> queryContent() {
        logger.info("开始查询");
        List<ConsultContent> content = commonService.queryContent(new HashMap());
        logger.info("结束查询");
        return content;
    }
}
