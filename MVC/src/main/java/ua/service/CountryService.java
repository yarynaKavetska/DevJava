package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Country;
import ua.form.filter.CountryFilterForm;

public interface CountryService {

	void save(Country country);
	
	Country findByName(String name);
	
	void delete(String name);
	
	List<Country> findAll();
	
	Page<Country> findAll(Pageable pageable);

	void delete(int id);

	List<Country> findWithRecipes();
	
	Country findOne(int id);

	Page<Country> findAll(Pageable pageable, CountryFilterForm form);

}
