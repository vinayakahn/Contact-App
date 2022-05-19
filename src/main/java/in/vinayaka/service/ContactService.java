package in.vinayaka.service;

import java.util.List;

import in.vinayaka.entity.Contact;

public interface ContactService {
	
	String upsert(Contact contact);
	List<Contact> getAllContacts();
	Contact getContact(int cid);
	String deleteContact(int cid);

}
