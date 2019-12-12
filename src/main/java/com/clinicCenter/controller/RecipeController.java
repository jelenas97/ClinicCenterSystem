package com.clinicCenter.controller;

import com.clinicCenter.model.Recipe;
import com.clinicCenter.model.User;
import com.clinicCenter.service.MedicamentService;
import com.clinicCenter.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/allRecipes")
    public List<Recipe> getAll(){
        return recipeService.getAll();
    }

    @GetMapping("/allValidatedRecipes")
    public List<Recipe> getAllValidate(){
        return recipeService.getAllValidated();
    }

    @GetMapping("/allRecipes/{id}")
    public void validate(@PathVariable Long id){
        Recipe recipe = recipeService.getById(id);
        recipe.setValidated(true);
        recipeService.save(recipe);
        System.out.println(recipe.getDescription());
    }
}
