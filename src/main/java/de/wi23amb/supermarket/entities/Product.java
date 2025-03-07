package de.wi23amb.supermarket.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import de.wi23amb.supermarket.config.UuidIdentifiedEntity;

@Document
public class Product extends UuidIdentifiedEntity {
	
	@Field("name")
	private String name;

	@Field("barcode")
	private String barcode;

	@Field("price")
	private double price;

	@Field("deposit")
	private double deposit;

	@Field("brand")
	@DBRef
	private Brand brand;

	public Product(String name, String barcode, double price, double deposit, Brand brand) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.price = price;
		this.deposit = deposit;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
}
