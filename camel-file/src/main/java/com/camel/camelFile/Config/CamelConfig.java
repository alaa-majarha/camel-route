package com.camel.camelFile.Config;

import com.camel.camelFile.routes.File;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.PropertiesComponent;
import org.springframework.stereotype.Component;

@Component("CamelConfig")
public class CamelConfig {
    public void setupRoutes() {
        try(CamelContext context = new DefaultCamelContext()) {
            context.addRoutes(new File());

            PropertiesComponent propertiesComponent = context.getPropertiesComponent();
            propertiesComponent.setLocation("classpath:application.properties");

            context.start();

            Thread.sleep(2000);

            context.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
