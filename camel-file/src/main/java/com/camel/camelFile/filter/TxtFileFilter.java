package com.camel.camelFile.filter;

import org.apache.camel.component.file.GenericFile;
import org.apache.camel.component.file.GenericFileFilter;
import org.springframework.stereotype.Component;

@Component
public class TxtFileFilter implements GenericFileFilter {
    @Override
    public boolean accept(GenericFile file) {
        return file.getFileName().endsWith(".txt");
    }
}
