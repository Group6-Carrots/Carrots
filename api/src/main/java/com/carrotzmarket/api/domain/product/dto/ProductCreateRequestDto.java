package com.carrotzmarket.api.domain.product.dto;

import com.carrotzmarket.api.domain.Address.Address;
import com.carrotzmarket.db.product.ProductStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ProductCreateRequestDto {

    @NotNull(message = "상품 제목은 필수입니다.")
    @NotBlank(message = "상품 제목을 입력해주세요.")
    private String title;

    @NotNull(message = "상품 설명은 필수입니다.")
    @NotBlank(message = "상품 설명을 입력해주세요.")
    private String description;

    @Positive(message = "가격은 0보다 큰 값이어야 합니다.")
    private int price;

    private Long userId;

//    private Long regionId;

    private Long categoryId;

    private ProductStatus status;

    private List<MultipartFile> images;

    private String province;
    private String city;
    private String town;
    private String village;
}
