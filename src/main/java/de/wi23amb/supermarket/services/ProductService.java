package de.wi23amb.supermarket.services;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import de.wi23amb.supermarket.dto.ProductDTO;
import de.wi23amb.supermarket.factories.ProductFactory;
import de.wi23amb.supermarket.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductFactory productFactory;

	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<Object>(productRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<Object> getById(@PathVariable UUID id) {
		try { 
			return new ResponseEntity<Object>(productRepository.findById(id).get(), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Product with ID "+id+" was not found.", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> getByBarcode(@PathVariable String barcode) {
		try { 
			return new ResponseEntity<Object>(productRepository.findByBarcode(barcode).get(), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Product with barcode "+barcode+" was not found.", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> create(@RequestBody ProductDTO productDTO) {
		try {
			return new ResponseEntity<Object>(productRepository.save(productFactory.create(productDTO)), HttpStatus.CREATED);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Brand with ID "+productDTO.getBrandId()+" was not found.", HttpStatus.NOT_FOUND);
		}
	}

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
