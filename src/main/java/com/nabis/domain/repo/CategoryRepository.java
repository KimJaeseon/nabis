package com.nabis.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabis.domain.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String>{
	CategoryEntity findByNm(String nm);
}
