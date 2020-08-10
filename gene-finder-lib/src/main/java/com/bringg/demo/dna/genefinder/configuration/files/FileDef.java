package com.bringg.demo.dna.genefinder.configuration.files;

import java.nio.charset.Charset;

public class FileDef {
    private String path;
    private Charset encoding;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Charset getEncoding() {
        return encoding;
    }

    public void setEncoding(Charset encoding) {
        this.encoding = encoding;
    }
}
