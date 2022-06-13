package com.example.shop.core.domain.product.domain;

import com.example.shop.core.domain.product.dto.ProductRequest;
import com.example.shop.core.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Collections;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //옷 이름
    private String name;

    private LocalDateTime regDate;

    //가격
    private Integer price;

    //설명
    private String description;

    //옷 분류(enum으로 분류 예정)
    private String category;

    //조회수
    private Integer viewCount;

    //구매개수
    private Integer purchaseCount;

    public static Product createProduct(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .regDate(LocalDateTime.now())
                .price(request.getPrice())
                .description(request.getDescription())
                .category(request.getCategory())
                .viewCount(0)
                .purchaseCount(0)
                .build();
    }


}
