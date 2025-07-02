package com.hansung.likelion.domain.web.dto;

import com.hansung.likelion.domain.entity.Gender;
import com.hansung.likelion.domain.entity.User;

public record GetUserRes (
        Long id,
        String username,
        Gender gender
){
    public static GetUserRes from(User user) {
        return new GetUserRes(user.getId(), user.getUsername(), user.getGender());
    }
}
