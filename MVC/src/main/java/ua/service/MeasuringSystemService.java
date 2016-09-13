package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.MeasuringSystem;
import ua.form.filter.MeasuringSystemFilterForm;

public interface MeasuringSystemService {

	void delete(int id);

	void save(MeasuringSystem measuringSystem);

	List<MeasuringSystem> findAll();

	Page<MeasuringSystem> findAll(Pageable pageable, MeasuringSystemFilterForm form);

	MeasuringSystem findOne(int id);

}
