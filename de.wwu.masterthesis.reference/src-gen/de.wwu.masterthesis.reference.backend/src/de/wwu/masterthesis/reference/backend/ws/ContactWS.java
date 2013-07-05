package de.wwu.masterthesis.reference.backend.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.wwu.masterthesis.reference.backend.Config;
import de.wwu.masterthesis.reference.backend.beans.ContactBean;
import de.wwu.masterthesis.reference.backend.datatypes.InternalIdWrapper;
import de.wwu.masterthesis.reference.backend.models.Contact;

@Path("/contact")
@Stateless
public class ContactWS {
	
	@EJB
	ContactBean contactBean;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response jsonGetAll(@QueryParam("filter") final String filter) {
		final GenericEntity<List<Contact>> contacts = new GenericEntity<List<Contact>>(contactBean.getAllContacts(filter)) {};
		Response response = Response
				.ok()
				.entity(contacts)
				.header("MD2-Model-Version", Config.MODEL_VERSION)
				.build();
		return response;
	}
	
	@GET
	@Path("/first")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response jsonGetFirst(@QueryParam("filter") final String filter) {
		final Contact contact = contactBean.getFirstContact(filter);
		final List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(contact);
		final GenericEntity<List<Contact>> contactEntity = new GenericEntity<List<Contact>>(contactList) {};
		Response response;
		
		if(contact != null) {
			response = Response
				.ok()
				.entity(contactEntity)
				.header("MD2-Model-Version", Config.MODEL_VERSION)
				.build();
		} else {
			response = Response
				.status(404)
				.header("MD2-Model-Version", Config.MODEL_VERSION)
				.build();
		}
		
		return response;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response jsonPut(List<Contact> contacts) {
		final GenericEntity<List<InternalIdWrapper>> ids = new GenericEntity<List<InternalIdWrapper>>(contactBean.putContacts(contacts)) {};
		Response response = Response
				.ok()
				.entity(ids)
				.header("MD2-Model-Version", Config.MODEL_VERSION)
				.build();
		return response;
	}
	
	@DELETE
	@Path("{id}")
	public Response jsonDelete(@PathParam("id") String id) {
		Response response;
		
		if(contactBean.deleteContact(id)) {
			response = Response
				.noContent()
				.header("MD2-Model-Version", Config.MODEL_VERSION)
				.build();
		} else {
			response = Response
				.status(404)
				.header("MD2-Model-Version", Config.MODEL_VERSION)
				.build();
		}
		
		return response;
	}
	
}
