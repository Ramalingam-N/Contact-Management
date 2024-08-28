package com.contact.service;

import com.contact.dto.ContactDto;

import java.util.List;

public interface ContactService {
    void saveContact(ContactDto contactDto);
    List<ContactDto> allContacts();
    ContactDto findContactById(Long contactId);
    void deleteContact(Long contactId);
    List<ContactDto> findByName(String name);
    boolean checkContactExist(Long id);
}
