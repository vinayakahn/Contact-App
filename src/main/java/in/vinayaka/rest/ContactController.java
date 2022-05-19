package in.vinayaka.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vinayaka.entity.Contact;
import in.vinayaka.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService service;
	
	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contact)
	{
		String status = service.upsert(contact);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts()
	{
		List<Contact> allcontacts = service.getAllContacts();
		return new ResponseEntity<>(allcontacts,HttpStatus.OK);
	}
	
	@GetMapping("/contact/{cid}")
	public ResponseEntity<Contact> getContact(@PathVariable int cid)
	{
		Contact contact = service.getContact(cid);
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable int cid)
	{
		String deleteContact = service.deleteContact(cid);
		return new ResponseEntity<>(deleteContact,HttpStatus.OK);
	}

}
