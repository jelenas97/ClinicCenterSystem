package com.clinicCenter.repository;

import com.clinicCenter.model.Recipe;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    @Query(value = "select * from Recipe r where r.validated=true", nativeQuery = true)
    List<Recipe> getAllValidatedRecipes();

    @Query(value = "select * from Recipe r where r.validated=false", nativeQuery = true)
    List<Recipe> getAllUnvalidated();

    @Lock(LockModeType.PESSIMISTIC_READ)
    Recipe save(Recipe recipe);
}
