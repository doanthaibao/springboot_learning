package bao.doan.learning.service;

import bao.doan.learning.model.User;
import bao.doan.learning.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        List< bao.doan.learning.domain.User> users = (List<bao.doan.learning.domain.User>) userRepository.findAll();
        return users.stream().map(item ->
                User.builder().name(item.getName())
                        .email(item.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    public User getUser(Long id) throws Exception {
        Optional<bao.doan.learning.domain.User> user = userRepository.findById(id);
        if(user.isPresent()){
            return User.builder().name(user.get().getName()).email(user.get().getEmail()).build();
        }
        throw new Exception("There are no item with id: " + id);
    }

    public boolean addNewUser(User user) {
        bao.doan.learning.domain.User sUser = bao.doan.learning.domain.User.builder()
                .email(user.getEmail())
                .imageUrl(user.getImageUrl())
                .isVerified(user.isVerified())
                .password(user.getPassword())
                .provider(user.getProvider())
                .providerId(user.getProviderId())
                .name(user.getName()).build();
        try {
            userRepository.save(sUser);
            return true;
        } catch (Exception e) {
            log.error("Error when adding user {}", e.getMessage());
        }
        return false;
    }
}
