package com.polpid.springboot20.user.service;


import com.polpid.springboot20.email.model.Email;
import com.polpid.springboot20.user.domain.Users;
import com.polpid.springboot20.user.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private Users users;

    @Before
    public void setup(){
        users = Users.builder().email(Email.builder().value("test@test.com").build())
                .firstName("Test")
                .lastName("Kim")
                .password("test1!")
                .build();
    }

    @Test
    public void findByEmailValueTest(){
        String email = "test@test.com";

        when(userRepository.findByEmailValue(email)).thenReturn(Optional.of(users));

        Optional<Users> byEmailValue = userService.findByEmailValue(email);

        assertThat(byEmailValue.get().getEmail().getValue()).isEqualTo(email);
    }
}
