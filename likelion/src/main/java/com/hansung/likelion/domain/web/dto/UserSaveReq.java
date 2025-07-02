package com.hansung.likelion.domain.web.dto;

import com.hansung.likelion.domain.entity.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveReq {
    @NotBlank(message = "이름은 필수입니다.")
    private String username;

    @NotNull(message = "성별을 입력해주세요.")
    private Gender gender;
}
