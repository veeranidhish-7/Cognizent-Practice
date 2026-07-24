package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryRepository countryRepository;

	/**
	 * Hands on 1 - return all countries.
	 */
	@Transactional
	public List<Country> getAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryRepository.findAll();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
		return countries;
	}

	/**
	 * Hands on 6 - find a country based on country code.
	 */
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		LOGGER.info("Start");
		LOGGER.debug("countryCode={}", countryCode);

		Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country not found");
		}

		Country country = result.get();
		LOGGER.debug("country={}", country);
		LOGGER.info("End");
		return country;
	}

	/**
	 * Hands on 7 - add a new country.
	 */
	@Transactional
	public void addCountry(Country country) {
		LOGGER.info("Start");
		LOGGER.debug("country={}", country);
		countryRepository.save(country);
		LOGGER.info("End");
	}

	/**
	 * Hands on 8 - update a country's name based on its code.
	 */
	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFoundException {
		LOGGER.info("Start");
		LOGGER.debug("code={}, name={}", code, name);

		Optional<Country> result = countryRepository.findById(code);

		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country not found");
		}

		Country country = result.get();
		country.setName(name);
		countryRepository.save(country);

		LOGGER.info("End");
	}

	/**
	 * Hands on 9 - delete a country based on its code.
	 */
	@Transactional
	public void deleteCountry(String code) {
		LOGGER.info("Start");
		LOGGER.debug("code={}", code);
		countryRepository.deleteById(code);
		LOGGER.info("End");
	}

	/**
	 * Bonus - find countries matching a partial country name (case-insensitive),
	 * as called out in the module objectives ("Find list of countries matching
	 * a partial country name").
	 */
	@Transactional
	public List<Country> findCountriesByPartialName(String partialName) {
		LOGGER.info("Start");
		LOGGER.debug("partialName={}", partialName);
		List<Country> countries = countryRepository.findByNameContainingIgnoreCase(partialName);
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
		return countries;
	}

}
