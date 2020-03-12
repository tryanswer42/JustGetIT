package be.vdab.justgetit.controllers;

import be.vdab.justgetit.domain.Categorie;
import be.vdab.justgetit.forms.FormCategorieStap1;
import be.vdab.justgetit.repositories.CategorieRepository;
import be.vdab.justgetit.services.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("categorieen")
public class CategorieenController {
    private final CategorieService categorieService;
    Set<Categorie> categorieSet = new LinkedHashSet<>();

    public CategorieenController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public String toonCategorieen() {
        return "category";
    }

    @GetMapping("/toevoegen")
    public ModelAndView showForm(){

        ModelAndView modelAndView = new ModelAndView("categorieen");
        modelAndView.addObject("categorieList", categorieService.findAll());
        modelAndView.addObject("formCategorieStap1", new FormCategorieStap1
                ("", BigDecimal.ZERO, false, false, 0));
        return modelAndView;
    }

@PostMapping("/toevoegen/form")
    public  String categorieToevoegen(@Valid FormCategorieStap1 categorieStap1, Errors errors){
    if (errors.hasErrors()){
        return "toevoegen";
    }
    Categorie categorie = new Categorie(0, categorieStap1.getNaam(),
            categorieStap1.isSubCategorie(), categorieStap1.isPercentage(), categorieStap1.getWinstmarge());
    if (categorieStap1.getParentCategorieId() != 0){
        Optional<Categorie> categorie1 = categorieService.findById(categorieStap1.getParentCategorieId());
        categorie.setParentCategory(categorie1.get());
    }
    categorieService.create(categorie);
    return "redirect:/";
}

}