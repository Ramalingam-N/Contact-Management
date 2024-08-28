package com.contact.dto;

import com.contact.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDto {

    private Long id;

    @NotEmpty(message = "Required")
    private String name;

    @NotEmpty(message = "Required")
    private String number;

    private String role;

    private LocalDateTime createdOn;

    private User user;
}
