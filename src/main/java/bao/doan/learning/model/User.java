package bao.doan.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotBlank
    private String name;

    @Min(0)
    @JsonIgnore
    private  int age;
}
