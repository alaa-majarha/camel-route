package com.camel.camelFile.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class File extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/main/resources/from?noop={{camel.properties.noop}}")
                .log("message: ${body}")
                .choice()
                .when(Exchange->Exchange.getIn().getBody(String.class).contains("\"payment directory\""))
                .toD("file:src/main/resources/{{exchangeProperty.destName}}?fileName=${file:name.noext}.txt")
                .otherwise()
                .to("file:src/main/resources/out")
                .end()
                .log("end processing");

    }
}
