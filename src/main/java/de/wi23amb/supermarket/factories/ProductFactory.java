package de.wi23amb.supermarket.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.wi23amb.supermarket.dto.ProductDTO;
import de.wi23amb.supermarket.entities.Brand;
import de.wi23amb.supermarket.entities.Product;
import de.wi23amb.supermarket.repositories.BrandRepository;

@Service
public class ProductFactory {
	
	@Autowired
	private BrandRepository brandRepository;

	public Product create(ProductDTO productDTO) {
		Brand brand = brandRepository.findById(productDTO.getBrandId()).get();
		
		Product product = new Product(
				productDTO.getName(), 
				productDTO.getBarcode(), 
				productDTO.getPrice(), 
				productDTO.getDeposit(), 
				brand);
		
		return product;
	}
	
}
