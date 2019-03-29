package com.vk.liyj.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LiyjListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
        System.out.println("ServletContext 销毁");
    }

    @Override
    public void contextInitialized(ServletContextEvent paramServletContextEvent) {
        System.out.println("ServletContext 初始化");
        System.out.println("getServerInfo---->" + paramServletContextEvent.getServletContext().getServerInfo());
    }

}
