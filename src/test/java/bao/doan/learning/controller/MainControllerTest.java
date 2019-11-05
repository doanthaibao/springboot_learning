package bao.doan.learning.controller;

import bao.doan.learning.config.TemperatureConfig;
import bao.doan.learning.model.AcmeProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@EnableConfigurationProperties(value = { AcmeProperties.class})
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

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
    public void getGreeting() {
    }
}