package com.evolent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolent.entity.Contact;
import com.evolent.exception.ContactNotFoundException;
import com.evolent.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> retrieveContactService() {
		return contactRepository.findAll();
	}

	public Contact retrieveContactByIdService(int contactId) {
		return contactRepository.findById(contactId).orElseThrow( () -> 
							new ContactNotFoundException("Operation can't perform because Contact Id: " + contactId + " is not found"));
	}

	public void saveContactService(Contact contact) {
		contactRepository.save(contact);
		
	}


	public Contact deleteContactService(int contactId) {
		contactRepository.deleteById(contactId);
		return null;
	}
	
	

}
