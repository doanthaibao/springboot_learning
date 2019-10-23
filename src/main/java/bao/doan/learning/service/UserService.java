package bao.doan.learning.service;

import bao.doan.learning.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser(){
        return User.builder().name("Bao").age(30).build();
    }
}
