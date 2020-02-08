package com.clinicCenter.service;

import com.clinicCenter.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllUnvalidated();
    List<Recipe> getAllValidated();
    Recipe getById(Long id);
    void save(Recipe recipe);
    void delete(Recipe recipe);
}
