package in.vinayaka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vinayaka.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	

}
