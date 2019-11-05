package bao.doan.learning.controller;

import bao.doan.learning.model.User;
import bao.doan.learning.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value = "Add new user",
            code = 200,
            extensions = {
                    @Extension(name = "external", properties = {
                            @ExtensionProperty(name = "context", value = "/users"),
                            @ExtensionProperty(name = "isPublished", value = "true")
                    })
            })
    public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
        log.info("Request add new user {}", user);
        userService.addNewUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/users")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = "Get all users",
            code = 200,
            extensions = {
                    @Extension(name = "external", properties = {
                            @ExtensionProperty(name = "context", value = "/users"),
                            @ExtensionProperty(name = "isPublished", value = "true")
                    })
            })
    public ResponseEntity<List<User>> getUsers() {
        log.info("Request get all user {}");
        return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
    }
}
