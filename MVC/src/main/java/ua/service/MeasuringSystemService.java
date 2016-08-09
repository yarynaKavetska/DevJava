package ua.service;

import java.util.List;

import ua.entity.MeasuringSystem;

public interface MeasuringSystemService {

	void delete(int id);

	void save(String name);

	List<MeasuringSystem> findAll();

}
