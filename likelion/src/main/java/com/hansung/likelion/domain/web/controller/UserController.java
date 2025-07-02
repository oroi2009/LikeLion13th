package com.hansung.likelion.domain.web.controller;

import com.hansung.likelion.domain.entity.Gender;
import com.hansung.likelion.domain.service.UserService;
import com.hansung.likelion.domain.web.dto.GetUserRes;
import com.hansung.likelion.domain.web.dto.UserSaveReq;
import com.hansung.likelion.global.response.SuccessResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<SuccessResponse<?>> saveUser(@Valid @RequestBody UserSaveReq userSaveReq) {
        userService.save(userSaveReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.empty());
    }

    @GetMapping("/{gender}")
    public ResponseEntity<SuccessResponse<?>> getUserByGender(@PathVariable Gender gender) {
        List<GetUserRes> users = userService.getUserByGender(gender);
        return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse.from(users));
    }
}
