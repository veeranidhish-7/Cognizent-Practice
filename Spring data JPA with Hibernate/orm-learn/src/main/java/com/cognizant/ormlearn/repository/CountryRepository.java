package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	// Query method - Spring Data JPA derives the query from the method name.
	// Finds all countries whose name contains the given text, case-insensitive.
	List<Country> findByNameContainingIgnoreCase(String partialName);

}
