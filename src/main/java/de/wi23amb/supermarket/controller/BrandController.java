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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.wi23amb.supermarket.entities.Brand;
import de.wi23amb.supermarket.repositories.BrandRepository;

@Controller
@RestController
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<Object>(brandRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable UUID id) {
		try { 
			return new ResponseEntity<Object>(brandRepository.findById(id).get(), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Brand with ID "+id+" was not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> create(@RequestBody Brand brand) {
		return new ResponseEntity<Object>(brandRepository.save(brand), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody Brand brand) {
		try { 
			brandRepository.findById(id).get();
			Brand newBrand = new Brand(
					brand.getName(), 
					brand.getStreet(), 
					brand.getHouseNr(), 
					brand.getCity(), 
					brand.getZipCode(), 
					brand.getCountry(),
					brand.getLegalForm());
			newBrand.setId(id);
			return new ResponseEntity<Object>(brandRepository.save(newBrand), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Brand with ID "+id+" was not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		try { 
			brandRepository.findById(id).get();
			brandRepository.deleteById(id);
			return new ResponseEntity<Object>("Brand with ID "+id+" was deleted.", HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Brand with ID "+id+" was not found.", HttpStatus.NOT_FOUND);
		}
	}

}
