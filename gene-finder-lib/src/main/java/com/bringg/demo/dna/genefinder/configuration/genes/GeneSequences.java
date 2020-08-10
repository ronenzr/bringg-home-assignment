package com.bringg.demo.dna.genefinder.configuration.genes;

import java.util.Set;

public class GeneSequences {

    private Set<String> sequences;

    public GeneSequences(Set<String> sequences) {
        this.sequences = sequences;
    }

    public Set<String> getSequences() {
        return sequences;
    }
}