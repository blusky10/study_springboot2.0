package com.polpid.springboot20.user.repository;


import com.polpid.springboot20.email.model.Email;
import com.polpid.springboot20.user.domain.Users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private Users users;

    @Before
    public void setup(){

        users = Users.builder().email(Email.builder().value("test@test.com").build())
                .firstName("Test")
                .lastName("Kim")
                .password("test123").build();

        userRepository.save(users);
    }

    @Test
    public void findByEmailTest(){
        Optional<Users> byEmail = userRepository.findByEmailValue("test@test.com");

        assertThat(byEmail).isNotNull();
        assertThat(byEmail.get().getEmail().getValue()).isEqualTo("test@test.com");
    }
}
