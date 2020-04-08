package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestGreetingController {

    private static final String template = "Hello, %s!";
    private static final String templateAgain = "Hello Again, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepo repo;

    @GetMapping("/Restgreeting")
    public RestGreeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {


        Iterable<Person> lista = repo.findAll();
        HashMap<String,Long> tabla=new HashMap<>();
        HashSet<String> Actuales=new HashSet<>();
        for (Person peronu : lista)
        {
            Actuales.add(peronu.getFirstName());
            tabla.put(peronu.getFirstName(),peronu.getId());
        }

        if (Actuales.contains(name))
            return new RestGreeting(tabla.get(name), String.format(templateAgain, name));
        else
        {
            Person newer =new Person(name);
            newer=repo.save(newer);

            return new RestGreeting(newer.getId(), String.format(template, name));
        }
    }
}
