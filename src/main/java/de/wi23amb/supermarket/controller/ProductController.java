package de.wi23amb.supermarket.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.wi23amb.supermarket.dto.ProductDTO;
import de.wi23amb.supermarket.services.ProductService;

@Controller
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable UUID id) {
		return productService.getById(id);
	}
	
	@GetMapping("/barcode/{barcode}")
	public ResponseEntity<Object> getByBarcode(@PathVariable String barcode) {
		return productService.getByBarcode(barcode);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> create(@RequestBody ProductDTO productDTO) {
		return productService.create(productDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		return productService.delete(id);
	}

}
