package bao.doan.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @GetMapping(path = "/exception/unit")
    public String getException(){
        throw new RuntimeException("Run-time exception");
    }
}
