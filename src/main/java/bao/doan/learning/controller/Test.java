package bao.doan.learning.controller;

import bao.doan.learning.model.User;
import bao.doan.learning.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class Test {

    @Autowired
    UserService userService;

    @GetMapping(path = "/test/user")
    @ApiOperation(
            value = "Get user",
            code = 200,
            extensions = {
                    @Extension(name = "external", properties = {
                            @ExtensionProperty(name = "context", value = "/test"),
                            @ExtensionProperty(name = "isPublished", value = "true")
                    })
            })
    @ResponseBody
    public User getUser(){
        return userService.getUser();
    }

    @PostMapping(path ="/test/user")
    @ApiOperation(
            value = "Post user",
            code = 200,
            extensions = {
                    @Extension(name = "external", properties = {
                            @ExtensionProperty(name = "context", value = "/test"),
                            @ExtensionProperty(name = "isPublished", value = "true")
                    })
            })
    @ResponseBody
    public ResponseEntity<String> postUser(@RequestBody @Valid User user){
        log.info("Post data to user {}", user);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
