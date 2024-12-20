package com.carrotzmarket.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RegionErrorCode implements ErrorCodeInterface {
    REGION_NOT_FOUND(400, 1600, "해당 지역을 찾을 수 없습니다."),
    INVALID_REGION(400, 1601, "유효하지 않은 지역ID");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
