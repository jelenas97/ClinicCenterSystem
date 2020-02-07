package com.clinicCenter.controller;

import com.clinicCenter.model.Recipe;
import com.clinicCenter.model.User;
import com.clinicCenter.service.MedicamentService;
import com.clinicCenter.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/allRecipes")
    @PreAuthorize("hasRole('NURSE')")
    public List<Recipe> getAll(){
        return recipeService.getAllUnvalidated();
    }

    @GetMapping("/allValidatedRecipes")
    public List<Recipe> getAllValidate(){
        return recipeService.getAllValidated();
    }

    @GetMapping("/validate/{id}")
    public void validate(@PathVariable Long id){
        recipeService.validate(id);
    }

    @DeleteMapping ("/allRecipes/removeRecipe/{id}")
    @PreAuthorize("hasRole('NURSE')")
    public void remove(@PathVariable Long id){
        Recipe recipe = recipeService.getById(id);
        recipeService.delete(recipe);
    }
}
