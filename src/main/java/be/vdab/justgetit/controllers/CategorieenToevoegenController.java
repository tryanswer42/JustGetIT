package be.vdab.justgetit.controllers;

import be.vdab.justgetit.domain.Categorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("categorieen")
public class CategorieenToevoegenController {

@GetMapping
    public ModelAndView showForm(){
    ModelAndView modelAndView = new ModelAndView("categorieen");
    modelAndView.addObject(new Categorie(0, "", 0, false, false, BigDecimal.ZERO ));
    return modelAndView;
}

}
