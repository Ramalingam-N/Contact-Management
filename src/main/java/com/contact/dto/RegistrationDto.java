package com.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDto {

    @NotEmpty(message = "Required")
    private String firstName;

    @NotEmpty(message = "Required")
    private String lastName;

    @Email
    @NotEmpty(message = "please enter your email")
    private String email;

    @NotEmpty(message = "please enter your password")
    private String password;
}
