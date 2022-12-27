package org.example;

import org.reactivestreams.Publisher;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static java.util.EnumSet.range;

public class FluxAndMonoGeneratorService {


    public <subscribe> Flux<String> namesFlux(){

        return Flux.fromIterable(List.of("shubham", "rahul", "viky"))
//                .log()
                ;


    }
    public Mono<String> nameMono(){
        return Mono.just("shubham")
//                .log()
                ;
    }


    public Flux<String> nameFlux_map(Integer stringLength){
        return Flux.fromIterable(List.of("shubham", "rahul", "viky"))
                .map(String::toUpperCase)
                .filter(e-> e.length()>stringLength)
                .map(s -> s+" = "+s.length())
//                .map(e-> e.toUpperCase())
//                .log()
                ;
    }

    public Flux<String> nameFlux_flatmap(Integer stringLength){
        return Flux.fromIterable(List.of("shubham", "rahul", "viky"))
                .map(String::toUpperCase)
                .filter(e-> e.length()>stringLength)

                .flatMap(s -> splitString(s))
//               .log()
                ;
    }

    private Flux<String> splitString(String name) {
        var charArray = name.split("");
        return Flux.fromArray(charArray);
    }

    //Reactive Stream are Immutable. In top working because its Initialise  in a same line.
//    after the initialisation its not muttable
    public Flux<String> nameFlux_map_immutability(){

        var namesFlux= Flux.fromIterable(List.of("shubham", "rahul", "viky"));
                namesFlux.map(String::toUpperCase);
//                .map(e-> e.toUpperCase())
                return namesFlux;
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
