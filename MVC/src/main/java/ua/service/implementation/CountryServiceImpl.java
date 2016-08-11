package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public void save(Country country) {
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

	@Override
	public void delete(int id) {
		countryRepository.delete(id);
	}

	@Override
	public Country findOne(int id) {
		return countryRepository.findOne(id);
	}

}
