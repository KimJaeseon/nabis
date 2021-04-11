package com.nabis.domain.entity;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class CategoryEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long idParent;

    private String title;

    private String icon;

    private String description;

    @CreationTimestamp
    private LocalDateTime createTimestamp;
    
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;

    @Builder
    public Category(Long idParent, String title, String icon, String description) {
        this.idParent = idParent;
        this.title = title;
        this.icon = icon;
        this.description = description;
    }
}
