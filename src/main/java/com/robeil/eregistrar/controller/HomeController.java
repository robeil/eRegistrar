package com.robeil.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home","/eRegistrar/home"})
    public String displayHomepage() {
        return "public/index";
    }

    @GetMapping(value = {"/eRegistrar/about"})
    public String displayAboutpage() {
        return "public/about";
    }

}
