package com.bringg.demo.dna.genefinder.services;

import com.bringg.demo.dna.genefinder.configuration.DnaConfig;
import com.bringg.demo.dna.genefinder.configuration.genes.GeneSequences;
import com.bringg.demo.dna.genefinder.exceptions.GeneNotFoundException;
import com.bringg.demo.dna.genefinder.exceptions.GeneNotSupportedException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;

@Service
public class GeneService {

    private DnaConfig dnaConfig;
    private GeneSequences geneSequences;

    public GeneService(GeneSequences geneSequences,
                       DnaConfig dnaConfig) {
        this.dnaConfig = dnaConfig;
        this.geneSequences = geneSequences;
    }

    public String find(String gene) throws GeneNotFoundException, GeneNotSupportedException {
        validateGeneInput(gene);

        if (geneSequences.getSequences().contains(gene)) {
            return gene;
        }

        throw new GeneNotFoundException();
    }

    //--

    private void validateGeneInput(String gene) throws GeneNotSupportedException {
        if (StringUtils.isEmpty(gene) ||
                !StringUtils.startsWithIgnoreCase(gene, dnaConfig.getPrefix())) {
            throw new GeneNotSupportedException(dnaConfig.getPrefix());
        }
    }
}
