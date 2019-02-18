package com.polpid.springboot20.user.repository;

import com.polpid.springboot20.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByResetToken(String resetToken);
    Optional<Users> findByEmailValue(String email);
}