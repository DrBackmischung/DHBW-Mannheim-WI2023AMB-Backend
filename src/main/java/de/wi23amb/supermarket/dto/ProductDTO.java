package de.wi23amb.supermarket.dto;

import java.util.UUID;

public class ProductDTO {
	
	private String name;
	private String barcode;
	private double price;
	private double deposit;
	private UUID brandId;
	
	public ProductDTO(String name, String barcode, double price, double deposit, UUID brandId) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.price = price;
		this.deposit = deposit;
		this.brandId = brandId;
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

	public UUID getBrandId() {
		return brandId;
	}

	public void setBrandId(UUID brandId) {
		this.brandId = brandId;
	}
	
}
