package org.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    getLogger().info("My context is initialized");
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    getLogger().info("My context is destroyed");
  }

  private Logger getLogger() {
    return LogManager.getLogger();
  }
}
