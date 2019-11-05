package bao.doan.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class User {
    @NotBlank
    private String name;

    @Email (message = "Invalid email address")
    private  String email;

    @NotNull
   // @JsonIgnore
    private boolean isVerified;

   // @JsonIgnore
    private String imageUrl;

    @NotBlank
   // @JsonIgnore
    private String password;

    @NotBlank
    //@JsonIgnore
    private String provider;

    @NotBlank
    //@JsonIgnore
    private String providerId;
}
