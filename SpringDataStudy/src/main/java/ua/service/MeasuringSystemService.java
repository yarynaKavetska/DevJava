package ua.service;

import java.util.List;

import ua.entity.MeasuringSystem;

public interface MeasuringSystemService {

	void save(String name);
	
	void delete(int id);
	
	List<MeasuringSystem> findAll();
}
