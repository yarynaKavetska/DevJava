package ua.service;

import java.util.List;

import ua.dto.RegionJson;

public interface RegionService {

	void save(RegionJson region);
	
	RegionJson findOne(int id);
	
	List<RegionJson> findAll();
	
	List<RegionJson> findAll(int countryId);
	
	void delete(int id);
	
}
