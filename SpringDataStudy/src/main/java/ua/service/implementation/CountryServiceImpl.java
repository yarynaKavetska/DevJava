package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public void save(String name) {
		Country country = new Country();
		country.setName(name);
		countryRepository.save(country);
	}

	@Override
	public Country findByName(String name) {
		return countryRepository.findByName(name);
	}

	@Override
	public void delete(String name) {
		countryRepository.delete(name);
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

}
