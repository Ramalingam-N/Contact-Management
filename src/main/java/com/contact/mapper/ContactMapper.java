package com.contact.mapper;

import com.contact.dto.ContactDto;
import com.contact.entity.Contact;

public class ContactMapper {
    public static ContactDto mapToContactDto(Contact contact){
        return ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .number(contact.getNumber())
                .createdOn(contact.getCreatedOn())
                .role(contact.getRole())
                .build();
    }

    public static Contact mapToContact(ContactDto contactDto){
        return Contact.builder()
                .id(contactDto.getId())
                .name(contactDto.getName())
                .number(contactDto.getNumber())
                .createdOn(contactDto.getCreatedOn())
                .role(contactDto.getRole())
                .build();
    }
}
