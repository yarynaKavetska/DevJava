package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country>{

	Country findByName(String name);
	
	default void delete(String name){
		delete(findByName(name));
	}
	@Query("SELECT DISTINCT c FROM Country c LEFT JOIN FETCH c.recipes")
	List<Country> findWithRecipes();
	
	@Modifying
	@Query("DELETE FROM Country c WHERE c.name=:name")
	void deleteByName(@Param("name") String name);
}
