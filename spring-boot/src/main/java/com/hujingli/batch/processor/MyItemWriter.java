package com.hujingli.batch.processor;

import com.hujingli.batch.bean.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyItemWriter  implements ItemWriter<Person> {


    @Override
    public void write(List<? extends Person> list) throws Exception {
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
