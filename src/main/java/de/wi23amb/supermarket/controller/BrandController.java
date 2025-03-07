package de.wi23amb.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
