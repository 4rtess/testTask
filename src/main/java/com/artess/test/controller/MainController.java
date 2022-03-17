package com.artess.test.controller;


import com.artess.test.entity.User;
import com.artess.test.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/createUser")
    public String createUser(@RequestParam String name) {
        userRepository.save(new User(name));
        System.out.println("endpoint createUser");
        return "ok";
    }

    @GetMapping("/getUsersFromDB")
    public String getUsers(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "user";

    }
}
