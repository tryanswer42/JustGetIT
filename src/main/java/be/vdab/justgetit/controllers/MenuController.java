package be.vdab.justgetit.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/m")
public class MenuController {

    @Value("1.0.0")
    private String webVersion;


    @GetMapping
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("menu");

        return modelAndView;

    }

}
