package com.hansung.likelion.domain.service;

import com.hansung.likelion.domain.entity.Gender;
import com.hansung.likelion.domain.entity.User;
import com.hansung.likelion.domain.exception.UserAlreadyExistException;
import com.hansung.likelion.domain.exception.UserErrorCode;
import com.hansung.likelion.domain.reposiory.UserRepository;
import com.hansung.likelion.domain.web.dto.GetUserRes;
import com.hansung.likelion.domain.web.dto.UserSaveReq;
import com.hansung.likelion.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 사용자 저장
    @Transactional
    public void save(UserSaveReq userSaveReq) {
            if (userRepository.findByUsername(userSaveReq.getUsername()).isPresent()) {
                // UserAlreadyExistException 만들기 전엔 return null;
                throw new UserAlreadyExistException();
            }

            User user = User.builder()
                    .username(userSaveReq.getUsername())
                    .gender(userSaveReq.getGender())
                    .build();

            userRepository.save(user);
    }

    // 성별로 사용자 조회
    public List<GetUserRes> getUserByGender(Gender gender){
        List<User> userList = userRepository.findAllByGender(gender);

        return userList.stream()
                .map(GetUserRes::from)
                .toList();
    }

}
