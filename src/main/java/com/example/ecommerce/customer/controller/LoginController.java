package com.example.ecommerce.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {


    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name) {
        session.setAttribute("name", name);


        return session.getId();
    }

    @GetMapping("/name")
    public String returnName(HttpSession session) {
        String name = (String)session.getAttribute("name");

        return name;
    }
}
