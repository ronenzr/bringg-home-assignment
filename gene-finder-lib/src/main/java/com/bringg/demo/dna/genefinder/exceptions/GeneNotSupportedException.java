package com.bringg.demo.dna.genefinder.exceptions;

public class GeneNotSupportedException extends Exception {

    public GeneNotSupportedException(String prefix) {
        super(String.format("Requested gene template is not supported, missing prefix: %s", prefix));
    }
}
