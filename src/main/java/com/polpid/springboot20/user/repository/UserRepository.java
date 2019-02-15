package com.polpid.springboot20.user.repository;

import java.util.Optional;

import com.polpid.springboot20.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByResetToken(String resetToken);
}