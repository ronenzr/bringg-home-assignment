package com.bringg.demo.dna.genefinder.services;

import com.bringg.demo.dna.genefinder.configuration.DnaConfig;
import com.bringg.demo.dna.genefinder.configuration.genes.GeneSequences;
import com.bringg.demo.dna.genefinder.exceptions.GeneNotFoundException;
import com.bringg.demo.dna.genefinder.exceptions.GeneNotSupportedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeneServiceTests {

    @Mock
    private GeneSequences geneSequences;

    @Mock
    private DnaConfig dnaConfig;

    @InjectMocks
    private GeneService geneService;

    @BeforeEach
    public void init() {
        final String prefix = "mock-prefix";
        when(dnaConfig.getPrefix()).thenReturn(prefix);
    }

    // find

    @Test
    public void find_geneExist_shouldReturnSuccessfully() throws GeneNotSupportedException, GeneNotFoundException {
        // Given
        final String gene = "mock-prefix-gene";
        final Set<String> supportedSequences = Collections.singleton(gene);

        when(geneSequences.getSequences()).thenReturn(supportedSequences);

        // When
        String result = geneService.find(gene);

        // Then
        assertEquals(gene, result);
    }

    @Test
    public void find_geneDoesNotExist_shouldThrowGeneNotFoundException() {
        // Given
        final String gene = "mock-prefix-gene";
        final String supportedGene = "mock-prefix-supported-gene";
        final Set<String> supportedSequences = Collections.singleton(supportedGene);

        when(geneSequences.getSequences()).thenReturn(supportedSequences);

        // When
        assertThrows(GeneNotFoundException.class, () -> geneService.find(gene));
    }

    @Test
    public void find_geneWithoutTemplatePrefix_shouldThrowGeneNotSupportedException() {
        // Given
        final String gene = "mock-otherprefix-gene";
        final String supportedGene = "mock-prefix-supported-gene";

        // When
        assertThrows(GeneNotSupportedException.class, () -> geneService.find(gene));
    }
}
