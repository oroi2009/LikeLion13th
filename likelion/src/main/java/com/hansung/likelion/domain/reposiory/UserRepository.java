package com.hansung.likelion.domain.reposiory;

import com.hansung.likelion.domain.entity.Gender;
import com.hansung.likelion.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findAllByGender(Gender gender);
}
