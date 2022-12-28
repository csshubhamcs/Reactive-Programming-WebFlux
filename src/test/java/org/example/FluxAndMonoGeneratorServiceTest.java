package org.example;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

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

Integer stringLength = 4;
        Flux<String> namesFlux = fluxAndMonoGeneratorService.nameFlux_map(stringLength);
        StepVerifier.create(namesFlux)
//                .expectNext("SHUBHAM","RAHUL","VIKY")
//                .expectNext("SHUBHAM","RAHUL")
//                .expectNext("shubham", "rahul", "viky")
                .expectNext("SHUBHAM = 7", "RAHUL = 5")
                .verifyComplete();
    }

    @Test
    void nameFlux_map_immutability() {
        Flux<String> namesFlux = fluxAndMonoGeneratorService.nameFlux_map_immutability();
        StepVerifier.create(namesFlux)
//                .expectNext("SHUBHAM","RAHUL","VIKY")
                .expectNext("shubham", "rahul", "viky")
                .verifyComplete();

    }

    @Test
    void nameFlux_flatmap() {
        Integer stringLength = 4;
        Flux<String> nameFlux = fluxAndMonoGeneratorService.nameFlux_flatmap(stringLength);
        StepVerifier.create(nameFlux)
                .expectNext("S","H","U","B","H","A","M","R","A","H","U","L");
    }

    @Test
    void nameMono_flatMap() {
        int stringLength = 2;
       Mono<List<String>> nameFlux = fluxAndMonoGeneratorService.nameMono_flatMap(stringLength);
        StepVerifier.create(nameFlux)
                .expectNext(List.of("S","H","U","B","H","A","M"))
                .verifyComplete();
    }
}