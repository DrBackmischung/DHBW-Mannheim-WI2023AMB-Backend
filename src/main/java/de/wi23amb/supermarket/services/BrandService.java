package de.wi23amb.supermarket.services;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import de.wi23amb.supermarket.entities.Brand;
import de.wi23amb.supermarket.repositories.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<Object>(brandRepository.findAll(), HttpStatus.OK);
	}

	@Cacheable(cacheNames="brand", key="#id")
	public ResponseEntity<Object> getById(@PathVariable UUID id) {
		System.out.println("Fetching brand with id "+id+"...");
		try { 
			return new ResponseEntity<Object>(brandRepository.findById(id).get(), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Brand with ID "+id+" was not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Object> create(@RequestBody Brand brand) {
		return new ResponseEntity<Object>(brandRepository.save(brand), HttpStatus.CREATED);
	}
	
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
