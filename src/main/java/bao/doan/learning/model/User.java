package bao.doan.learning.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class User {
    @NotBlank
    private String name;
    @Min(0)
    private  int age;
}
