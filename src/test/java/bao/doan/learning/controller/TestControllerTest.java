package bao.doan.learning.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bao.doan.learning.config.TemperatureConfig;
import bao.doan.learning.model.AcmeProperties;
import bao.doan.learning.model.User;
import bao.doan.learning.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@EnableConfigurationProperties(value = { AcmeProperties.class})
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Autowired
    private AcmeProperties acmeProperties;

    @MockBean
    TemperatureConfig temperatureConfig;

    @MockBean
    MessageSource messageSource;

    @Before
    public void setup() {

    }

    @Test
    public void getUserTest() throws Exception {
        Mockito.when(userService.getUser()).thenReturn(User.builder().name("A").age(10).build());
        mvc.perform(get("/test/user")
                .contentType("application/json;charset=UTF-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("A"));
    }
}