package com.contact.controller;

import com.contact.dto.ContactDto;
import com.contact.dto.RegistrationDto;
import com.contact.service.ContactService;
import com.contact.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    private ContactService contactService;
    private UserService userService;
    public ContactController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @GetMapping("user/contacts")
    public String allContacts(Model model){
        List<ContactDto> contactDtoList = contactService.allContacts();
        model.addAttribute("contacts", contactDtoList);
        return "all_contact";
    }

    @GetMapping("/user/create-contact")
    public String createContactForm(Model model){
        ContactDto contact = new ContactDto();
        model.addAttribute("contact", contact);
        return "create_contact_form";
    }

    @PostMapping("/user/create-contact")
    public String createContact(@Valid @ModelAttribute("contact") ContactDto contactDto,
                                BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("contact", contactDto);
            return "create_contact_form";
        }
        if(contactDto.getRole().isEmpty()){
            contactDto.setRole("---");
        }
        contactService.saveContact(contactDto);
        return "redirect:/user/contacts";
    }

    @PostMapping("/user/edit-contact")
    public String editContact(@Valid @ModelAttribute("contact") ContactDto contactDto,
                                BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("contact", contactDto);
            return "edit_contact";
        }
        if(contactDto.getRole().isEmpty()){
            contactDto.setRole("---");
        }
        contactService.saveContact(contactDto);
        return "redirect:/user/contacts";
    }

    @GetMapping("/user/edit-contact/{contactId}")
    public String editContact(@PathVariable("contactId") Long id, Model model){

        ContactDto contactDto = contactService.findContactById(id);
        if(contactDto.getId() == -1){
            return "/error/404";
        }
        model.addAttribute("contact", contactDto);
        return "edit_contact";
    }

    @GetMapping("/user/delete-contact/{contactId}")
    public String deleteContact(@PathVariable("contactId") Long contactId){

        if(!contactService.checkContactExist(contactId))
            return "error/404";

        contactService.deleteContact(contactId);
        return "redirect:/user/contacts";
    }

    @GetMapping("/user/search-contact")
    public String searchContact(@RequestParam(name = "name") String name, Model model){
        List<ContactDto> contactDtoList = contactService.findByName(name);
        model.addAttribute("contacts", contactDtoList);
        return "search_contacts";
    }

    @GetMapping("/register")
    public String userRegister(Model model){
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("register", registrationDto);
        return "user-register";
    }

}
