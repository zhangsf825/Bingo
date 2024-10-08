package com.bingo.modules.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 修改密码
 */
@Data
@Schema(description = "修改密码")
public class SysPasswordDTO implements Serializable {

    @Schema(description = "原密码")
    @NotBlank(message = "原密码不能为空")
    private String password;

    @Schema(description = "新密码")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;

}