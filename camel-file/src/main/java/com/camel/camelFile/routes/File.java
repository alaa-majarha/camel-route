package com.camel.camelFile.routes;

import com.camel.camelFile.filter.TxtFileFilter;
import org.apache.camel.builder.RouteBuilder;


public class File extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/main/resources/input?noop={{camel.properties.noop}}")
                .log("File content: ${body}")
                .setProperty("destName",simple("out"))
                .filter().method(TxtFileFilter.class)
                .toD("file:src/main/resources/${exchangeProperty.destName}?fileName=${file:name.noext}.txt")
                .log("File moved to output folder with name: ${file:name.noext}.txt");
    }
}
