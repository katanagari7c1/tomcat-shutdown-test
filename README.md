# Testing Logging in Web Application
This web application uses log4j as the logging framework and contains a single `ContextListener`
that creates and uses a Logger either when the web context is created and when its destroyed.

Note that the log message is printed via console when the context starts, but logger
configuration fails when logger is created while the context is being destroyed:

```
INFO: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
16:51:12.177 INFO  org.test.MyServletContextListener - My context is initialized
[2018-12-11 04:51:12,211] Artifact tomcat-shutdown-test:Web exploded: Artifact is deployed successfully
...

Once Tomcat starts shutting down

...
INFO: Stopping service Catalina
2018-12-11 16:56:44,722 localhost-startStop-2 ERROR No Log4j 2 configuration file found. Using default configuration (logging only errors to the console), or user programmatically provided configurations. Set system property 'log4j2.debug' to show Log4j 2 internal initialization logging. See https://logging.apache.org/log4j/2.x/manual/configuration.html for instructions on how to configure Log4j 2
Dec 11, 2018 4:56:44 PM org.apache.coyote.AbstractProtocol stop
``` 

This application uses a custom log4j config file defined in `web.xml`. This error appears when attempting to reconfigure
log4j during context destruction.

## How to use this code
This project can be opened using Eclipse or IntelliJ IDEs and deploying the application from there as usual.
Another option is downloading the .war file in the _releases_ section and deploying it in a existing Tomcat instance.
 