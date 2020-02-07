package com.evolent.service;

import java.util.List;

import com.evolent.entity.Contact;


public interface ContactService {
	
	public List<Contact> retrieveContactService();

	public Contact retrieveContactByIdService(int contactId);

	public void saveContactService(Contact contact);

	Contact deleteContactService(int contactId);

}
