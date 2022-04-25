package br.edu.iftm.imobiliaria.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

public class FlywayConfig implements ServletContextListener {

    public void configure() {
        try {
            Context ctx = new InitialContext();
            Flyway flyway = Flyway.configure().dataSource((DataSource) ctx.lookup("java:comp/env/jdbc/TestDB")).load();
            flyway.migrate();
        } catch (NamingException ex) {
            Logger.getLogger(FlywayConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        configure();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Quando aplicacao encerra
    }



}
