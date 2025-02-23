package com.carrotzmarket.api.domain.user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    @NotNull
    private String loginId;

    @NotNull
    private String password;
}
