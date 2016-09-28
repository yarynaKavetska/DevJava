package ua.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.RegionJson;
import ua.entity.Country;
import ua.entity.Region;
import ua.repository.CountryRepository;
import ua.repository.RegionRepository;
import ua.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public void save(RegionJson json) {
		Country country = countryRepository.findOne(json.getCountryId());
		Region region = new Region();
		region.setCountry(country);
		region.setId(json.getId());
		region.setName(json.getName());
		regionRepository.save(region);
	}

	@Override
	@Transactional
	public RegionJson findOne(int id) {
		Region region = regionRepository.findOne(id);
		RegionJson json = new RegionJson();
		json.setCountryId(region.getCountry().getId());
		json.setCountryName(region.getCountry().getName());
		json.setId(region.getId());
		json.setName(region.getName());
		return json;
	}

	@Override
	@Transactional
	public List<RegionJson> findAll() {
		List<RegionJson> jsons = new ArrayList<>();
		for(Region region : regionRepository.findAll()){
			RegionJson json = new RegionJson();
			json.setCountryId(region.getCountry().getId());
			json.setCountryName(region.getCountry().getName());
			json.setId(region.getId());
			json.setName(region.getName());
			jsons.add(json);
		}
		return jsons;
	}

	@Override
	public void delete(int id) {
		regionRepository.delete(id);
	}

	@Override
	@Transactional
	public List<RegionJson> findAll(int countryId) {
		List<RegionJson> jsons = new ArrayList<>();
		for(Region region : regionRepository.findByCountryId(countryId)){
			RegionJson json = new RegionJson();
			json.setCountryId(region.getCountry().getId());
			json.setCountryName(region.getCountry().getName());
			json.setId(region.getId());
			json.setName(region.getName());
			jsons.add(json);
		}
		return jsons;
	}
}
