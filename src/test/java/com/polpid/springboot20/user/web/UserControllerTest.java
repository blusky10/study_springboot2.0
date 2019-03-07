package com.polpid.springboot20.user.web;

import com.polpid.springboot20.email.model.Email;
import com.polpid.springboot20.user.domain.Users;
import com.polpid.springboot20.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;

    private Users users;

    @Before
    public void setUp(){
        users = Users.builder()
                .email(Email.builder().value("test@test.com").build())
                .firstName("TEST")
                .lastName("KIM")
                .password("password")
                .build();
    }

    @Test
    public void getUserTest() throws Exception {

        given(this.userController.getUser("test@test.com")).willReturn(new UserDto.Res(this.users));

        ResultActions resultActions = this.mockMvc.perform(
                get("/users/{email}", "test@test.com"))
                .andDo(print());

        resultActions
                .andExpect(jsonPath("firstName").value("TEST"))
                .andExpect(jsonPath("lastName").value("KIM"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
