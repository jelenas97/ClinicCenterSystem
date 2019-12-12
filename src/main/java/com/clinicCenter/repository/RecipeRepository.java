package com.clinicCenter.repository;

import com.clinicCenter.model.Recipe;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    @Query(value = "select * from Recipe r where r.validated=true", nativeQuery = true)
    List<Recipe> getAllValidatedRecipes();
}
