package ua.service;

import java.util.List;

import ua.entity.Country;

public interface CountryService {

	void save(Country country);
	
	Country findByName(String name);
	
	void delete(String name);
	
	List<Country> findAll();

	void delete(int id);

	Country findOne(int id);
}
