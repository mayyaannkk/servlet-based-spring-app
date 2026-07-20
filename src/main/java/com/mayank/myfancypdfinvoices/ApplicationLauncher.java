package com.mayank.myfancypdfinvoices;

import com.mayank.myfancypdfinvoices.context.ApplicationConfiguration;
import jakarta.servlet.ServletContext;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationLauncher {
    static void main() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);


        WebApplicationContext appCtx = createApplicationContext(context.getServletContext());

        DispatcherServlet dispatcherServlet = new DispatcherServlet(appCtx);


        Wrapper wrapper = Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);

        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/*");

        tomcat.start();
    }

    private static WebApplicationContext createApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ApplicationConfiguration.class);
        ctx.setServletContext(servletContext);
        ctx.refresh();
        ctx.registerShutdownHook();
        return ctx;
    }
}
