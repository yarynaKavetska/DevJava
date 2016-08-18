package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Country;

public interface CountryService {

	void save(Country country);
	
	Country findByName(String name);
	
	void delete(String name);
	
	Page<Country> findAll(Pageable pageable);

	void delete(int id);

	Country findOne(int id);

	List<Country> findAll();
}
