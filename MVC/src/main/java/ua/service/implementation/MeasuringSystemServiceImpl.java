package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.MeasuringSystem;
import ua.form.filter.MeasuringSystemFilterForm;
import ua.repository.MeasuringSystemRepository;
import ua.service.MeasuringSystemService;
import ua.service.implementation.specification.MeasuringSystemFilterAdapter;
@Service
public class MeasuringSystemServiceImpl implements MeasuringSystemService{

	@Autowired
	private MeasuringSystemRepository measuringSystemRepository;
	
	@Override
	public void delete(int id) {
		measuringSystemRepository.delete(id);
	}

	@Override
	public void save(MeasuringSystem system) {
		measuringSystemRepository.save(system);
	}

	@Override
	public List<MeasuringSystem> findAll() {
		return measuringSystemRepository.findAll();
	}

	@Override
	public Page<MeasuringSystem> findAll(Pageable pageable, MeasuringSystemFilterForm form) {
		return measuringSystemRepository.findAll(new MeasuringSystemFilterAdapter(form),pageable);
	}

	@Override
	public MeasuringSystem findOne(int id) {
		return measuringSystemRepository.findOne(id);
	}
}
