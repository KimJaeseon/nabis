package com.nabis.mappers;

import com.nabis.domain.entity.CategoryEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
	
	private String nm;
	private String labelNm; 
	private int orderNo;
	
	public CategoryEntity toEntity(){
        return CategoryEntity.builder()
        		.nm(nm)
        		.labelNm(labelNm)
        		.orderNo(orderNo)
                .build();
    }
}
