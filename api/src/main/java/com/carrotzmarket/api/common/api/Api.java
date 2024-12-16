package com.carrotzmarket.api.common.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result; // 들어온 요청에 대한 처리 결과
    private T data; // 요청 결과 데이터

    // 응답 성공
    public static <T> Api<T> OK(T data) {
        Api<T> api = new Api<>();
        api.result = Result.OK(); // 성공했음
        api.data = data; // 요청에 대한 데이터 설정
        return api;
    }

    // 에러 처리
    public static Api<Object> ERROR(Result result){
        Api<Object> api = new Api<>();
        api.result = result;
        return api;
    }
}
