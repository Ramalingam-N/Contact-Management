package com.contact.service.impl;

import com.contact.dto.ContactDto;
import com.contact.entity.Contact;
import com.contact.entity.User;
import com.contact.mapper.ContactMapper;
import com.contact.repository.ContactRepository;
import com.contact.repository.UserRepository;
import com.contact.security.SecurityUtils;
import com.contact.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private UserRepository userRepository;
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveContact(ContactDto contactDto) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Contact contact = ContactMapper.mapToContact(contactDto);
        contact.setUser(user);
        contactRepository.save(contact);
    }

    @Override
    public List<ContactDto> allContacts() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Long id = user.getId();
        List<Contact> contacts = contactRepository.findCurrentUserContacts(id);
        return contacts.stream().map(ContactMapper::mapToContactDto).collect(Collectors.toList());
    }

    @Override
    public ContactDto findContactById(Long contactId) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Long id = user.getId();
        List<Contact> contacts = contactRepository.findCurrentUserContacts(id);
        for(Contact c : contacts){
            if(contactId.equals(c.getId())){
                return ContactMapper.mapToContactDto(c);
            }
        }
        ContactDto ans = new ContactDto();
        ans.setId(-1L);
        return ans;
    }

    @Override
    public void deleteContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId).get();
        contactRepository.delete(contact);
    }

    @Override
    public List<ContactDto> findByName(String name) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Long userId = user.getId();

        List<Contact> contacts = contactRepository.findByName(name);
        List<Contact> filteredContacts = contacts.stream()
                .filter(contact -> contact.getUser().getId().equals(userId))
                .collect(Collectors.toList());

        return filteredContacts.stream()
                .map(ContactMapper::mapToContactDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkContactExist(Long id) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Long userId = user.getId();
        List<Contact> contacts = contactRepository.findCurrentUserContacts(userId);
        for(Contact c : contacts){
            if(id.equals(c.getId())){
                return true;
            }
        }
        return false;
    }


}
