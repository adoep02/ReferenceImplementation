package de.wwu.masterthesis.reference.android.models;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import de.wwu.md2.android.lib.controller.contentprovider.InternalIdSerializer;
import de.wwu.md2.android.lib.model.Entity;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("group")
public class Group implements Entity {
	
	@JsonDeserialize(contentAs=Group.class)
	@JsonRootName("group")
	public static class Array extends ArrayList<Group> {
		private static final long serialVersionUID = 1L;
		public Array() {
		}
	}
	
	@JsonSerialize(using=InternalIdSerializer.class)
	@JsonDeserialize
	private int __internalId;
	private String name;
	
	public Group() {
		applyDefaults();
	}
	
	private void applyDefaults() {
		__internalId = -1;
	}
	
	@JsonIgnore
	public void setInternalId(int id) {
		__internalId = id;
	}

	@JsonIgnore
	public int getInternalId() {
		return __internalId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
}
