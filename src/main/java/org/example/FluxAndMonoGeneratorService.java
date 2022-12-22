package org.example;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static java.util.EnumSet.range;

public class FluxAndMonoGeneratorService {


    public <subscribe> Flux<String> namesFlux(){

        return Flux.fromIterable(List.of("shubham", "rahul", "viky"))
                .log();


    }
    public Mono<String> nameMono(){
        return Mono.just("shubham")
                .log();
    }


    public Flux<String> nameFlux_map(){
        return Flux.fromIterable(List.of("shubham", "rahul", "viky"))
                .map(String::toUpperCase)
//                .map(e-> e.toUpperCase())
                .log();
    }



    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();


        fluxAndMonoGeneratorService.namesFlux().subscribe(name -> {
            System.out.println("name : "+name);
        });

        fluxAndMonoGeneratorService.nameMono().subscribe(name -> {
            System.out.println(" My name : "+ name);
        });

    }

}
