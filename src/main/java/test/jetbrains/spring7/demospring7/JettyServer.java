package test.jetbrains.spring7.demospring7;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class JettyServer {
    private static final Logger log = LoggerFactory.getLogger(JettyServer.class);

    private static final int DEFAULT_PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String CONFIG_LOCATION = "test.jetbrains.spring7.demospring7";
    private static final String MAPPING_URL = "/*";

    public static void main(String[] args) throws Exception {
        // Create and configure a WebApplicationContext
        WebApplicationContext context = createWebApplicationContext();

        // Create a new Jetty server
        Server server = new Server(DEFAULT_PORT);

        // Create a ServletContextHandler with the specified context path
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath(CONTEXT_PATH);

        // Add the WebApplicationContext as a context listener
        servletContextHandler.addEventListener(new ContextLoaderListener(context));

        // Create a servlet holder for the DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletHolder servletHolder = new ServletHolder(dispatcherServlet);
        servletHolder.setInitOrder(1);

        // Add the servlet holder to the context handler
        servletContextHandler.addServlet(servletHolder, MAPPING_URL);

        // Set the handler for the server
        server.setHandler(servletContextHandler);

        // Start the server
        server.start();
        log.info("Server started at port {}", DEFAULT_PORT);
        server.join();
    }

    private static WebApplicationContext createWebApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }
}
