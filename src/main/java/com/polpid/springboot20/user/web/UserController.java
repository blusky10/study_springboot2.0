package com.polpid.springboot20.user.web;

import com.polpid.springboot20.user.domain.Users;
import com.polpid.springboot20.user.dto.UserDto;
import com.polpid.springboot20.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/{email:.+}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto.Res getUser(@PathVariable("email") @Valid final String email){
        Optional<Users> users = userService.findByEmailValue(email);

        return new UserDto.Res(users.get());
    }

}
