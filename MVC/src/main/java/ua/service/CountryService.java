package ua.service;

import java.util.List;

import ua.entity.Country;

public interface CountryService {

	void save(String name);
	
	Country findByName(String name);
	
	void delete(String name);
	
	List<Country> findAll();

	void delete(int id);

	List<Country> findWithRecipes();
	
	Country findOne(int id);
}
