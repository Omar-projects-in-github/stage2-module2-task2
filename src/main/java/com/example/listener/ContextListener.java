package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        LocalDateTime createdTime = LocalDateTime.now();
        servletContext.setAttribute("servletTimeInit", createdTime);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
