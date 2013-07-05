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
import de.wwu.masterthesis.reference.backend.beans.GroupBean;
import de.wwu.masterthesis.reference.backend.datatypes.InternalIdWrapper;
import de.wwu.masterthesis.reference.backend.models.Group;

@Path("/group")
@Stateless
public class GroupWS {
	
	@EJB
	GroupBean groupBean;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response jsonGetAll(@QueryParam("filter") final String filter) {
		final GenericEntity<List<Group>> groups = new GenericEntity<List<Group>>(groupBean.getAllGroups(filter)) {};
		Response response = Response
				.ok()
				.entity(groups)
				.header("MD2-Model-Version", Config.MODEL_VERSION)
				.build();
		return response;
	}
	
	@GET
	@Path("/first")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response jsonGetFirst(@QueryParam("filter") final String filter) {
		final Group group = groupBean.getFirstGroup(filter);
		final List<Group> groupList = new ArrayList<Group>();
		groupList.add(group);
		final GenericEntity<List<Group>> groupEntity = new GenericEntity<List<Group>>(groupList) {};
		Response response;
		
		if(group != null) {
			response = Response
				.ok()
				.entity(groupEntity)
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
	public Response jsonPut(List<Group> groups) {
		final GenericEntity<List<InternalIdWrapper>> ids = new GenericEntity<List<InternalIdWrapper>>(groupBean.putGroups(groups)) {};
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
		
		if(groupBean.deleteGroup(id)) {
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
