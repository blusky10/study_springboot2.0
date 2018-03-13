package com.polpid.springboot20.user.service;

import com.polpid.springboot20.domain.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByResetToken(String resetToken);
    public void save(User user);
}