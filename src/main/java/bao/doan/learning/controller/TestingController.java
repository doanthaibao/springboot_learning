package bao.doan.learning.controller;

import bao.doan.learning.domain.Book;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@ConditionalOnProperty(value = "features.test",
        matchIfMissing = false)
public class TestingController {

    @PostMapping("/test/book")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity postAuthor(@RequestBody @Valid Book book) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
