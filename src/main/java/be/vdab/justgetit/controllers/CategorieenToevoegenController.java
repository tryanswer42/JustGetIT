package be.vdab.justgetit.controllers;

import be.vdab.justgetit.domain.Categorie;
import be.vdab.justgetit.repositories.CategorieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("categorieen")
public class CategorieenToevoegenController {

    private final CategorieRepository categorieRepository;

    public CategorieenToevoegenController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @GetMapping
    public ModelAndView showForm(){

    ModelAndView modelAndView = new ModelAndView("categorieen");
    modelAndView.addObject("categorieList", categorieRepository.findAll());
    modelAndView.addObject("categor",new Categorie(0, "", 0, false, false, BigDecimal.ZERO ));
    return modelAndView;
}

@PostMapping
    public  ModelAndView categorieToevoegen();

}
