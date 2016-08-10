package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

	@Query("SELECT i FROM Ingredient i WHERE i.name=:name")
	Ingredient findByName(@Param("name") String name);
}