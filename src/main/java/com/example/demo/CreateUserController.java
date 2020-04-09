package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CreateUserController {
    @Autowired
    PersonRepo repo;

    @GetMapping("/createuser")
    public String greeting(Model model) {


//    	UserDetails user = new User("user@example.com", passwordEncoder.encode("s3cr3t"), authorities);

        return "ok";
    }
}
