package com.bringg.demo.dna.genefinder.configuration;

import com.bringg.demo.dna.genefinder.configuration.files.FileDef;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dna")
public class DnaConfig {
    private String prefix;
    private List<FileDef> files;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<FileDef> getFiles() {
        return files;
    }

    public void setFiles(List<FileDef> files) {
        this.files = files;
    }
}
