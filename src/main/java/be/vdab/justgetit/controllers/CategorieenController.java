package be.vdab.justgetit.controllers;

import be.vdab.justgetit.domain.Categorie;
import be.vdab.justgetit.repositories.CategorieRepository;
import be.vdab.justgetit.services.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("categorieen")
public class CategorieenController {
    private final CategorieService categorieService;

    public CategorieenController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/toevoegen")
    public ModelAndView showForm(){

        ModelAndView modelAndView = new ModelAndView("categorieen");
        modelAndView.addObject("categorieList", categorieService.findAll());
        modelAndView.addObject("categor",new Categorie(0, "", false, false, BigDecimal.ZERO ));
        return modelAndView;
    }

//@PostMapping
//    public  ModelAndView categorieToevoegen();
//
}