package com.bringg.demo.dna.genefinder.exceptions;

public class MissingConfigurationException extends Exception {

    public MissingConfigurationException(){ }
    public MissingConfigurationException(String message) {
        super(message);
    }
}
