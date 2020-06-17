package com.hujingli.webflux.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BasicController {

    @GetMapping("/hello")
    public Mono<String> sayHelloWorld(){
        return Mono.just("hello world");
    }

}
