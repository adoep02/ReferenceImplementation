package de.wwu.masterthesis.reference.backend.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.wwu.masterthesis.reference.backend.Utils;
import de.wwu.masterthesis.reference.backend.datatypes.InternalIdWrapper;
import de.wwu.masterthesis.reference.backend.models.Group;

@Stateless
public class GroupBean {
	
	@PersistenceContext(unitName = "de.wwu.masterthesis.reference.backend")
    EntityManager em;
	
	/*
	 * TODO Implement backend logic for the Group entity here.
	 * These bean methods should be accessed from the web services.
	 */
	
	
	/*
	 * Default logic to get and set Group entities
	 */
	
	public List<Group> getAllGroups(String filter) {
		List<Group> result = em.createQuery("SELECT t FROM Group t " + Utils.buildWhereParameterFromFilterString(filter), Group.class)
			.getResultList();
		
		return result;
	}
	
	public Group getFirstGroup(String filter) {
		List<Group> result = em.createQuery("SELECT t FROM Group t " + Utils.buildWhereParameterFromFilterString(filter), Group.class)
			.setMaxResults(1)
			.getResultList();
		
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<InternalIdWrapper> putGroups(List<Group> groups) {
		ArrayList<InternalIdWrapper> ids = new ArrayList<InternalIdWrapper>();
		
		for(Group group : groups) {
			group = em.merge(group);
								
			ids.add(new InternalIdWrapper(group.getInternal__id()));
		}
		return ids;
	}
	
	public boolean deleteGroup(String id) {
		Group group = em.find(Group.class, Integer.parseInt(id));
		
		if(group != null) {
			em.remove(group);
			return true;
		} else {
			return false;
		}
	}
}
