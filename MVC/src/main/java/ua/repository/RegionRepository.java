package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {

	
}
