package com.hansung.likelion.domain.exception;

import com.hansung.likelion.global.exception.BaseException;

public class UserAlreadyExistException extends BaseException {
    public UserAlreadyExistException() { super(UserErrorCode.USER_ALREADY_EXIST_409); }
}
