package com.bootdemo.lmy.demo.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

/**
 * @author 李
 * @create 2019/9/25 23:29
 */
@Data
public class AccessTokenDTO {
    @NotNull
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
