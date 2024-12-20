package com.carrotzmarket.db.product;

import com.carrotzmarket.db.category.CategoryEntity;
import com.carrotzmarket.db.transaction.ProductTransactionEntity;

import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;
import lombok.Setter;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = false, nullable = true)
    private Long userId;

    @Column(name = "region_id", nullable = false)
    private Long regionId;

    @Column(length = 100, nullable = false)
    private String title;

    @Lob
    private String description;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "view_count", nullable = false)
    private int viewCount;

    @Column(name = "favorite_count", nullable = false)
    private int favoriteCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductTransactionEntity transaction;

    // 수정된 부분: 카테고리 다대다 관계
    @ManyToMany
    @JoinTable(
            name = "product_category",  // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "product_id"),  // 제품 ID
            inverseJoinColumns = @JoinColumn(name = "category_id")  // 카테고리 ID
    )
    private List<CategoryEntity> categories;  // 여러 카테고리를 저장

}
