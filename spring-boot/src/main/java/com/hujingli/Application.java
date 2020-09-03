package com.hujingli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class);

        ClassLoader classLoader = Application.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("1.txt");
        System.out.println(resourceAsStream);
        System.out.println(classLoader.getResource("1.txt").getPath());

        byte[] bytes = new byte[1024];
        resourceAsStream.read(bytes);
        System.out.println(new String(bytes));

    }

}
