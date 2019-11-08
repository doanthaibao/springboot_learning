package bao.doan.learning.controller;

import bao.doan.learning.connector.FakeConnector;
import bao.doan.learning.connector.model.Note;
import bao.doan.learning.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@ConditionalOnProperty(value = "features.test",
        matchIfMissing = false)
public class TestingController {
    @Autowired
    FakeConnector fakeConnector;

    @PostMapping("/test/book")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity postAuthor(@RequestBody @Valid Book book) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("test/note")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Note> getNote() throws Exception {
        return new ResponseEntity<Note>(fakeConnector.getNote(), HttpStatus.OK);
    }

    @PostMapping("/test/note")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> getNote(@RequestBody Note note) throws Exception {
        return new ResponseEntity<String>(String.valueOf(fakeConnector.postNote(note)), HttpStatus.OK);
    }
}
