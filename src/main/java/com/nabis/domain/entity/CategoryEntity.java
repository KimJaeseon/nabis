package com.nabis.domain.entity;





import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CategoryEntity {
	
	@Id
    private String nm;
    private String labelNm;
    private int orderNo;
    
    @Builder
    public CategoryEntity(String nm, String labelNm, int orderNo) {
    	this.nm = nm;
    	this.labelNm = labelNm;
    	this.orderNo = orderNo;
    }
}
