package de.wi23amb.supermarket.repositories;

import java.util.Optional;

import de.wi23amb.supermarket.config.CustomMongoRepository;
import de.wi23amb.supermarket.entities.Product;

public interface ProductRepository extends CustomMongoRepository<Product> {
	Optional<Product> findByBarcode(String barcode);
}
