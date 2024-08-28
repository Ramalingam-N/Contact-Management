package com.contact.repository;

import com.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query(value = "SELECT * FROM contacts WHERE name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    List<Contact> findByName(String name);

    @Query(value = "SELECT c.* FROM contacts c INNER JOIN users u ON c.user_id = u.id WHERE u.id = :currentId",
            nativeQuery = true)
    List<Contact> findCurrentUserContacts(Long currentId);
}
