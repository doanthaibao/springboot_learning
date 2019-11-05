package bao.doan.learning.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bao.doan.learning.model.User;
import bao.doan.learning.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
//https://stackoverflow.com/questions/44200720/difference-between-mock-mockbean-and-mockito-mock

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Before
    public void setup() {

    }

    @Test
    public void getUsersTest() throws Exception {
        Mockito.when(userService.getUsers()).thenReturn((Arrays.asList(new User[]{User.builder().name("Bao").email("doanthaibao@gmail.com").build()})));
        mvc.perform(get("/users")
                .contentType("application/json;charset=UTF-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Bao"));
    }

    @Test
    public void postNewUser() throws Exception {
        Mockito.when(userService.addNewUser(Matchers.any())).thenReturn(true);
        User user = User.builder().name("A").email("abc@gmail.com").isVerified(true).password("1234").imageUrl("").provider("VN").providerId("1234").build();
        mvc.perform(post("/users")
                .contentType("application/json;charset=UTF-8")
                .content(asJsonString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
