package de.wi23amb.supermarket.controller;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import de.wi23amb.supermarket.factories.ProductFactory;
import de.wi23amb.supermarket.repositories.ProductRepository;

@Controller
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductFactory productFactory;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<Object>(productRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable UUID id) {
		try { 
			return new ResponseEntity<Object>(productRepository.findById(id).get(), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Product with ID "+id+" was not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> create(@RequestBody ProductDTO productDTO) {
		try {
			return new ResponseEntity<Object>(productRepository.save(productFactory.create(productDTO)), HttpStatus.CREATED);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Brand with ID "+productDTO.getBrandId()+" was not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		try { 
			productRepository.findById(id).get();
			productRepository.deleteById(id);
			return new ResponseEntity<Object>("Product with ID "+id+" was deleted.", HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Product with ID "+id+" was not found.", HttpStatus.NOT_FOUND);
		}
	}

}
