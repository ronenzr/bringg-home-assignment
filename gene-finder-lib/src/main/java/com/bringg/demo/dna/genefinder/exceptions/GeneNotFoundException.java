package com.bringg.demo.dna.genefinder.exceptions;

public class GeneNotFoundException extends Exception {
    public GeneNotFoundException() {
        super("Requested gene could not be found");
    }

    public GeneNotFoundException(String message) {
        super(message);
    }
}
