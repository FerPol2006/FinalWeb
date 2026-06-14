package com.upiiz.ajax.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping("/admin.html")
    public String admin() {
        return "admin";
    }

    @GetMapping("/carreras.html")
    public String carreras() {
        return "carreras";
    }

    @GetMapping("/aspirantes.html")
    public String aspirantes() {
        return "aspirantes";
    }

    @GetMapping("/constancias.html")
    public String constancias() {
        return "constancias";
    }
}
