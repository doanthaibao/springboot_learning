package bao.doan.learning.connector;

import bao.doan.learning.connector.model.Note;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeConnector {

    public Note getNote() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Note> response = restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/1",
                    HttpMethod.GET,
                    httpEntity,
                    Note.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new Exception("Error when do note request");
        }
    }

    public int postNote(Note note) throws Exception{
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        try {
            RestTemplate restTemplate = new RestTemplate();
            Note response = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts",
                    note, Note.class);
            return response.getId();
        } catch (HttpClientErrorException e) {
            throw new Exception("Error when do note request");
        }
    }
}
