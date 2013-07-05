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
@JsonRootName("contact")
public class Contact implements Entity {
	
	@JsonDeserialize(contentAs=Contact.class)
	@JsonRootName("contact")
	public static class Array extends ArrayList<Contact> {
		private static final long serialVersionUID = 1L;
		public Array() {
		}
	}
	
	@JsonSerialize(using=InternalIdSerializer.class)
	@JsonDeserialize
	private int __internalId;
	private Integer photo;
	private String name;
	private String firstname;
	private Integer phone;
	private String email;
	private String street;
	private String city;
	private Integer zipCode;
	
	public Contact() {
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
	
	public Integer getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(Integer value) {
		this.photo = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(String value) {
		this.firstname = value;
	}
	
	public Integer getPhone() {
		return this.phone;
	}
	
	public void setPhone(Integer value) {
		this.phone = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public void setStreet(String value) {
		this.street = value;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String value) {
		this.city = value;
	}
	
	public Integer getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(Integer value) {
		this.zipCode = value;
	}
	
}
