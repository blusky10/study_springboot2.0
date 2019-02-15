package com.polpid.springboot20.user.service;

import com.polpid.springboot20.domain.Users;

import java.util.Optional;

public interface UserService {
    public Optional<Users> findUserByEmail(String email);
    public Optional<Users> findUserByResetToken(String resetToken);
    public void save(Users user);
}