package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.AmountAndIngredient;

public interface AmountAndIngredientRepository extends JpaRepository<AmountAndIngredient, Integer>, JpaSpecificationExecutor<AmountAndIngredient>{

	@Query("SELECT ai FROM AmountAndIngredient ai LEFT JOIN FETCH "
			+ "ai.measuringSystem LEFT JOIN FETCH ai.ingredient")
	List<AmountAndIngredient> findAll();
	
	@Query(value="SELECT ai FROM AmountAndIngredient ai LEFT JOIN FETCH "
			+ "ai.measuringSystem LEFT JOIN FETCH ai.ingredient",
			countQuery="SELECT count(ai.id) FROM AmountAndIngredient ai")
	Page<AmountAndIngredient> findAll(Pageable pageable);
	
	@Query("SELECT ai FROM AmountAndIngredient ai LEFT JOIN FETCH "
			+ "ai.measuringSystem ms LEFT JOIN FETCH ai.ingredient i "
			+ "WHERE ai.id=:id")
	AmountAndIngredient findForForm(@Param("id")int id);
}
