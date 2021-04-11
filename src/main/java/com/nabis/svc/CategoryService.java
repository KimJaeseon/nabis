package com.nabis.svc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabis.domain.entity.CategoryEntity;
import com.nabis.domain.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	public Map<CategoryEntity, List<CategoryEntity>> getCategory() {
        List<CategoryEntity> menuList = categoryRepository.findAll();

        // Parent
        List<CategoryEntity> parentMenuList = menuList.stream()
            .filter(category -> category.getIdParent() == CategoryConstant.PARENT_ROOT)
            .collect(Collectors.toList())
            ;

        // Child
        Map<Long, List<CategoryEntity>> childMenuMap = menuList.stream()
            .filter(category -> category.getIdParent() != CategoryConstant.PARENT_ROOT)
            .collect(Collectors.groupingBy(CategoryEntity::getIdParent))
            ;

        // TreeMenu
        Map<CategoryEntity, List<CategoryEntity>> menuMap = new HashMap<>();
        for(CategoryEntity parent : parentMenuList){
            Long id = parent.getId();
            List<CategoryEntity> child = childMenuMap.get(id);
            menuMap.put(parent, child);
        }
        Map<CategoryEntity, List<CategoryEntity>> sortedMenuMap = 
            menuMap.entrySet().stream()
            .sorted((e1, e2)-> e1.getKey().getId().compareTo(e2.getKey().getId()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMenuMap;
    }
}
