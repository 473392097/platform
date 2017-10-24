package com.sudao.cloud.component.user.manager.platform.base.listeners;

import com.sudao.cloud.component.user.manager.platform.base.core.ApplicationContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by fuqinqin on 2017/7/28.
 */
public class InitContextListener implements ServletContextListener{
    private static final Logger logger = LoggerFactory.getLogger(InitContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //init applicationContext
        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContextHolder.setApplicationContext(
                (WebApplicationContext)servletContext.getAttribute(
                        WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE));
        logger.info("applicationContext has inited successfully...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
