package com.contact.service;

import com.contact.dto.RegistrationDto;
import com.contact.entity.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}
