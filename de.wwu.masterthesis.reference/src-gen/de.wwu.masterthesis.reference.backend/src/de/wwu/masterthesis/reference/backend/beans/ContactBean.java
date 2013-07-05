package de.wwu.masterthesis.reference.backend.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.wwu.masterthesis.reference.backend.Utils;
import de.wwu.masterthesis.reference.backend.datatypes.InternalIdWrapper;
import de.wwu.masterthesis.reference.backend.models.Contact;

@Stateless
public class ContactBean {
	
	@PersistenceContext(unitName = "de.wwu.masterthesis.reference.backend")
    EntityManager em;
	
	/*
	 * TODO Implement backend logic for the Contact entity here.
	 * These bean methods should be accessed from the web services.
	 */
	
	
	/*
	 * Default logic to get and set Contact entities
	 */
	
	public List<Contact> getAllContacts(String filter) {
		List<Contact> result = em.createQuery("SELECT t FROM Contact t " + Utils.buildWhereParameterFromFilterString(filter), Contact.class)
			.getResultList();
		
		return result;
	}
	
	public Contact getFirstContact(String filter) {
		List<Contact> result = em.createQuery("SELECT t FROM Contact t " + Utils.buildWhereParameterFromFilterString(filter), Contact.class)
			.setMaxResults(1)
			.getResultList();
		
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<InternalIdWrapper> putContacts(List<Contact> contacts) {
		ArrayList<InternalIdWrapper> ids = new ArrayList<InternalIdWrapper>();
		
		for(Contact contact : contacts) {
			contact = em.merge(contact);
								
			ids.add(new InternalIdWrapper(contact.getInternal__id()));
		}
		return ids;
	}
	
	public boolean deleteContact(String id) {
		Contact contact = em.find(Contact.class, Integer.parseInt(id));
		
		if(contact != null) {
			em.remove(contact);
			return true;
		} else {
			return false;
		}
	}
}
