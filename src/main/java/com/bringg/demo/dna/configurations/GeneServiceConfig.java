package com.bringg.demo.dna.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackageClasses = {
        com.bringg.demo.dna.genefinder.configuration.DnaConfig.class,
        com.bringg.demo.dna.genefinder.services.GeneService.class
})
public class GeneServiceConfig {
}
