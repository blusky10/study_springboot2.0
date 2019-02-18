package com.polpid.springboot20.user.service;

import com.polpid.springboot20.user.domain.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> findByEmailValue(String email);
    Optional<Users> findUserByResetToken(String resetToken);
    void save(Users user);
}