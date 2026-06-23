package com.camel.camel_file.routes;

import org.apache.camel.builder.RouteBuilder;


public class File extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:src/main/resources/input?noop=true")
                .log("File content: ${body}")
                .to("file:src/main/resources/out");
    }
}
