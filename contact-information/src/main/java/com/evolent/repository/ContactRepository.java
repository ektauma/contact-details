package com.evolent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evolent.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
