package com.evolent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.entity.Contact;
import com.evolent.exception.ContactNotFoundException;
import com.evolent.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Contact Informations!!!!")
@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("/contacts")
	@ApiOperation(value = "Get list of Contact Details in the System ", response = Iterable.class, tags = "getAllContacts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	public List<Contact> getAllContacts() {

		List<Contact> contactList = contactService.retrieveContactService();

		return contactList;
	}

	@GetMapping("/contacts/{contactId}")
	@ApiOperation(value = "Get specific Contact's details in the System ", response = Contact.class, tags = "getContactById")
	public Contact getContactById(@PathVariable int contactId) {

		Contact Contact = contactService.retrieveContactByIdService(contactId);

		if (Contact == null) {
			throw new ContactNotFoundException("Contact Id: " + contactId + " is not found");
		}

		return Contact;
	}

	@PostMapping("/contacts")
	@ApiOperation(value = "Post specific Contact's details in the System ", response = Contact.class, tags = "addContact")
	public Contact addContact(@RequestBody Contact contact) {

		contact.setContactId(0);

		contactService.saveContactService(contact);
		return contact;
	}

	@PutMapping("/contacts/{contactId}")
	@ApiOperation(value = "Put specific Contact's details in the System ", response = Contact.class, tags = "updateContact")
	public void updateContact(@RequestBody Contact contact, @PathVariable int contactId) {

		Contact Contact = contactService.retrieveContactByIdService(contactId);

		if (Contact == null) {
			throw new ContactNotFoundException("Updation can't perform because Contact Id: " + contactId + " is not found");
		}

		contactService.saveContactService(contact);

	}

	@DeleteMapping("/contacts/{contactId}")
	@ApiOperation(value = "Delete specific Contact's details in the System ", response = Contact.class, tags = "deleteContact")
	public String deleteContact(@PathVariable int contactId) {

		Contact contact = contactService.retrieveContactByIdService(contactId);

		if (contact == null) {
			throw new ContactNotFoundException(
					"Deletion can't perform because Contact Id: " + contactId + " is not found");
		}
		contactService.deleteContactService(contactId);

		return "Deleted Contact with ID: " + contactId;
	}

}
