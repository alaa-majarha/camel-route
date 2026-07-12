package com.spring.soap.produce;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>
    messageDispatcherServlet(ApplicationContext context) {

        MessageDispatcherServlet servlet =
                new MessageDispatcherServlet();

        servlet.setApplicationContext(context);

        return new ServletRegistrationBean<>(
                servlet,
                "/ws/*"
        );
    }


    //////////  WSDL Config   /////////////

    @Bean(name = "account")
    public DefaultWsdl11Definition accountWsdl(
            XsdSchema schema) {

        DefaultWsdl11Definition wsdl =
                new DefaultWsdl11Definition();

        wsdl.setPortTypeName("AccountPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace(
                "http://example.com/account"
        );
        wsdl.setSchema(schema);

        return wsdl;
    }


    @Bean
    public XsdSchema accountSchema() {

        return new SimpleXsdSchema(
                new ClassPathResource(
                        "xsd/account.xsd"
                )
        );
    }
}