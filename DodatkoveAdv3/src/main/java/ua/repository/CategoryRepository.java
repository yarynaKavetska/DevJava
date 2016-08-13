package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category>{

	List<Category> findByParentIsNull();
	
	List<Category> findByParentId(int id);
}
