package com.hujingli.webflux.rest;

import com.hujingli.webflux.bean.User;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

/**
 * 服务端推送
 */
@RestController
public class SseController {

    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> sse(){
        return Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).map(val-> "val->"+val);
    }

    @GetMapping(value = "/sse1")
    public Flux<ServerSentEvent<String>> sse1(){
        return Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).map(val-> ServerSentEvent.<String>builder()
                .data(val.toString())
                .event("Test_event")
                .id(UUID.randomUUID().toString())
                .build());   // 可以采用js jquery 或vue   发送eventsource来进行连接通信
    }


}
