package de.wi23amb.supermarket.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import de.wi23amb.supermarket.config.UuidIdentifiedEntity;

@Document
public class Brand extends UuidIdentifiedEntity {

	@Field("name")
	private String name;

	@Field("street")
	private String street;

	@Field("houseNr")
	private String houseNr;

	@Field("city")
	private String city;

	@Field("zipCode")
	private String zipCode;

	@Field("country")
	private String country;

	@Field("legalForm")
	private String legalForm;

	public Brand(String name, String street, String houseNr, String city, String zipCode, String country,
			String legalForm) {
		super();
		this.name = name;
		this.street = street;
		this.houseNr = houseNr;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.legalForm = legalForm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLegalForm() {
		return legalForm;
	}

	public void setLegalForm(String legalForm) {
		this.legalForm = legalForm;
	}
	
}
