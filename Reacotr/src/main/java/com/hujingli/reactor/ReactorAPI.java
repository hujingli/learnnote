package com.hujingli.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class ReactorAPI {


    @Test
    public void testSimpleGenerate() throws InterruptedException {
        Flux.just("Hello", "World").subscribe(System.out::print);
        System.out.println();
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::print);
        System.out.println();

        Flux.empty().subscribe(System.out::print);
        System.out.println();

        Flux.range(1, 10).subscribe(System.out::print);
        System.out.println();

        Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::print);
        System.out.println();

        Thread.currentThread().join(2 * 1000L);
    }

    @Test
    public void testGenerate(){
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);


        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

    }

    @Test
    public void testCreate() throws InterruptedException {

        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
//                if (i == 5){
//                    throw new RuntimeException("龙哥异常");
//                }

            }
            fluxSink.complete();
        }).subscribe(System.out::print, e-> System.out.println(e.getMessage()), ()-> System.out.println("龙哥威武"));

    }

    @Test
    public void testBuffer(){
        Flux<List<Integer>> buffer = Flux.range(1, 100).buffer(20);

        System.out.println(buffer.collectList());

        System.out.println( buffer.subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {

            }
        }));
    }


}
