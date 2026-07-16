package com.mayank;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {
    static void main() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);
        Wrapper wrapper = Tomcat.addServlet(context, "myFirstServlet", new MyFancyPdfInvoicesServlet());

        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/*");

        tomcat.start();
    }
}
