package com.hujingli.design.builder;

public class Main {

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .basic("胡红", 24, "男")
                .height(178).width(150).loc(new Location("成都市", "建设中路"))
                .build();

        System.out.println(person);
    }

}
