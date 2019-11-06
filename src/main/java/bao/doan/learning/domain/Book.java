package bao.doan.learning.domain;

import bao.doan.learning.error.valilator.Author;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Book {
    @Author
    @NotEmpty(message = "Please provide a author")
    private String author;

}
