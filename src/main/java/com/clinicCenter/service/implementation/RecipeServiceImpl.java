package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Recipe;
import com.clinicCenter.repository.RecipeRepository;
import com.clinicCenter.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllUnvalidated() {
        return recipeRepository.getAllUnvalidated();
    }

    @Override
    public List<Recipe> getAllValidated() {
        return recipeRepository.getAllValidatedRecipes();
    }

    @Override
    public Recipe getById(Long id) {
        return recipeRepository.findById(id).get();
    }

    @Override
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

}
