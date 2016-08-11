package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

	@Query("SELECT r FROM Recipe r LEFT JOIN FETCH r.country "
			+ "WHERE r.id=:id")
	Recipe findOneCountryInited(@Param("id") int id);
	
	@Query("SELECT distinct r FROM Recipe r LEFT JOIN FETCH r.amountAndIngredients"
			+ " ai LEFT JOIN FETCH ai.ingredient LEFT JOIN FETCH ai.measuringSystem"
			+ " where r.id=:id")
	Recipe findOneAmountInited(@Param("id") int id);

}
