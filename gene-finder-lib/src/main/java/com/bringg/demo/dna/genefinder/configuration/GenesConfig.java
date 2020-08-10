package com.bringg.demo.dna.genefinder.configuration;

import com.bringg.demo.dna.genefinder.configuration.genes.GeneSequences;
import com.bringg.demo.dna.genefinder.exceptions.MissingConfigurationException;
import com.bringg.demo.dna.genefinder.services.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class GenesConfig {

    @Bean
    @Scope("singleton")
    public GeneSequences constructGeneSequences(DnaConfig dnaConfig, FileService fileService) throws MissingConfigurationException {
        validateConfiguration(dnaConfig);
        Set<String> supportedGeneSequences = retrieveGeneSequences(dnaConfig, fileService);
        return new GeneSequences(supportedGeneSequences);
    }

    //--

    private void validateConfiguration(DnaConfig dnaConfig) throws MissingConfigurationException {
        if (StringUtils.isEmpty(dnaConfig.getPrefix())) {
            throw new MissingConfigurationException("Missing prefix configuration");
        }
        if (dnaConfig.getFiles() == null || StringUtils.isEmpty(dnaConfig.getFiles().isEmpty())) {
            throw new MissingConfigurationException("Missing dna files configuration");
        }
    }

    private Set<String> retrieveGeneSequences(DnaConfig dnaConfig, FileService fileService) {
        return dnaConfig.getFiles().stream()
                                    .flatMap(file -> fileService.findStringsByPrefix(file.getPath(),
                                            file.getEncoding(),
                                            dnaConfig.getPrefix()).stream())
                                    .filter(Objects::nonNull)
                                    .collect(Collectors.toSet());
    }
}
