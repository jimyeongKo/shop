package com.example.shop.core.domain.user.persistence;

import com.example.shop.core.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUserId(String userId);
    Boolean existsByPhoneNum(String phoneNum);
    User findByUserId(String userId);
}
