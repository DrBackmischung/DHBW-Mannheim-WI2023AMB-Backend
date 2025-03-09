package de.wi23amb.supermarket.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import de.wi23amb.supermarket.services.BrandService;

@Controller
@RestController
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable UUID id) {
		return brandService.getById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> create(@RequestBody Brand brand) {
		return brandService.create(brand);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody Brand brand) {
		return brandService.update(id, brand);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		return brandService.delete(id);
	}

}
