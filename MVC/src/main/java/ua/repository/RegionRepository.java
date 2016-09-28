package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{
	@Query("SELECT r FROM Region r JOIN r.country c WHERE c.id=?1")
	List<Region> findByCountryId(int countryId);

}
