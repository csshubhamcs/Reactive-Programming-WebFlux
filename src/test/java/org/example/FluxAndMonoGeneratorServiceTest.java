package org.example;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService=new FluxAndMonoGeneratorService();
    
    @Test
    void namesFlux() {

        Flux<String> namesFlux = fluxAndMonoGeneratorService.namesFlux();

        StepVerifier.create(namesFlux)
                .expectNext("shubham", "rahul", "viky").verifyComplete();
        StepVerifier.create(namesFlux)  .expectNextCount(3)

        .verifyComplete();
    }


    @Test
    void nameMono() {
    }

    @Test
    void main() {
    }

    @Test
    void nameFlux_map() {

        Flux<String> namesFlux = fluxAndMonoGeneratorService.nameFlux_map();
        StepVerifier.create(namesFlux)
                .expectNext("SHUBHAM","RAHUL","VIKY")
                .verifyComplete();
    }
}