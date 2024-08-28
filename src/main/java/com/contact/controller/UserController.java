package com.contact.controller;

import com.contact.dto.RegistrationDto;
import com.contact.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/register")
    public String registerUser(@Valid @ModelAttribute("register")RegistrationDto registrationDto,
                               BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("register", registrationDto);
            return "user-register";
        }
        userService.saveUser(registrationDto);
        return "login";
    }
    @GetMapping("/login")
    public String signIn(){
        return "login";
    }


}
