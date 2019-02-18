package com.polpid.springboot20.user.domain;

import com.polpid.springboot20.email.model.Email;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "reset_token")
    private String resetToken;

    @Embedded
    private Email email;

}