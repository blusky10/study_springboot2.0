package com.polpid.springboot20.user.dto;

import com.polpid.springboot20.email.model.Email;
import com.polpid.springboot20.user.domain.Users;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embedded;

public class UserDto {

    @Getter
    public static class Res{
        private long id;

        private String firstName;

        private String lastName;

        @Embedded
        private Email email;

        @Builder
        public Res(Users users) {
            this.id = users.getId();
            this.firstName = users.getFirstName();
            this.lastName = users.getLastName();
            this.email = users.getEmail();
        }
    }
}
