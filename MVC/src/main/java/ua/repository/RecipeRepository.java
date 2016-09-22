package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Country;
import ua.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	
	@Query("SELECT r FROM Recipe r LEFT JOIN FETCH r.country WHERE r.id=:id")
	Recipe findOneCountryInited(@Param("id")int id);

	Recipe findByName(String name);
//	@Query(value = "SELECT r FROM Recipe r LEFT JOIN FETCH r.country",
//			countQuery="SELECT count(r.id) FROM Recipe r LEFT JOIN r.country")
//	Page<Recipe> findAll(Pageable pageable);
	@Modifying
	@Query("UPDATE Recipe r SET r.country = :country WHERE r.name = :name")
	void changeCountry(@Param("name")String name, @Param("country")Country country);
	
}
