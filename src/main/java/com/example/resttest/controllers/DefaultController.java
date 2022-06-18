package com.example.resttest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DefaultController {

    @GetMapping("/swagger" )
    public String swagger() {
        return "redirect:/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/";
    }
}
