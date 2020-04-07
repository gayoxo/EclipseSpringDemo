package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;


@Controller
public class GreetingController {
    @Autowired
    PersonRepo repo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {


        Iterable<Person> lista = repo.findAll();

        HashSet<String> Actuales=new HashSet<>();
        for (Person peronu : lista)
            Actuales.add(peronu.getFirstName());

        if (Actuales.contains(name))
            model.addAttribute("name", " de nuevo, "+name);
        else
            {
                model.addAttribute("name", name);
                Person newer =new Person(name);
                repo.save(newer);
            }
        return "greeting";
    }
}
