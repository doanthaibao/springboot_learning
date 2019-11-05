package bao.doan.learning.service;

import static org.mockito.Mockito.spy;

import bao.doan.learning.model.User;
import bao.doan.learning.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setup(){
        userService = spy(new UserService());
        userService.userRepository = this.userRepository;
    }

    @Test
    public void addNewUserTest(){
        User user = User.builder().name("A").email("abc@gmail.com").isVerified(true).password("1234").provider("VN").providerId("1234").build();
        bao.doan.learning.domain.User expectedUser = bao.doan.learning.domain.User.builder()
                .name("A")
                .email("abc@gmail.com")
                .isVerified(true)
                .password("1234")
                .provider("VN")
                .providerId("1234").build();
        Mockito.when(userRepository.save(Matchers.any())).thenReturn(expectedUser);
        boolean result = userService.addNewUser(user);
        Mockito.verify(userRepository).save(expectedUser);
        Assert.assertEquals(result, true);
    }
}
