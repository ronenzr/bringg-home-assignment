package com.bringg.demo.dna.controllers;

import com.bringg.demo.dna.genefinder.exceptions.GeneNotFoundException;
import com.bringg.demo.dna.genefinder.exceptions.GeneNotSupportedException;
import com.bringg.demo.dna.genefinder.services.GeneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genes")
public class GenesController {

    private GeneService geneService;

    public GenesController(GeneService geneService) {
        this.geneService = geneService;
    }

    @GetMapping("/find/{gene}")
    public String findGene(@PathVariable String gene) throws GeneNotSupportedException, GeneNotFoundException {
        return geneService.find(gene);
    }
}
