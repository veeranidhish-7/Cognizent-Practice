package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {
		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
		testFindCountryByCode();
		testAddCountry();
		testUpdateCountry();
		testFindCountriesByPartialName();
		testDeleteCountry();
	}

	/**
	 * Hands on 1 - Spring Data JPA quick example.
	 */
	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	/**
	 * Hands on 6 - find a country based on country code.
	 */
	private static void testFindCountryByCode() {
		LOGGER.info("Start");
		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Country not found", e);
		}
		LOGGER.info("End");
	}

	/**
	 * Hands on 7 - add a new country, then look it back up to confirm it was
	 * persisted.
	 */
	private static void testAddCountry() {
		LOGGER.info("Start");

		Country newCountry = new Country("ZZ", "Testlandia");
		countryService.addCountry(newCountry);

		try {
			Country added = countryService.findCountryByCode("ZZ");
			LOGGER.debug("Added country:{}", added);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Country not found after add", e);
		}

		LOGGER.info("End");
	}

	/**
	 * Hands on 8 - update the country added above with a different name.
	 */
	private static void testUpdateCountry() {
		LOGGER.info("Start");
		try {
			countryService.updateCountry("ZZ", "Testlandia Updated");
			Country updated = countryService.findCountryByCode("ZZ");
			LOGGER.debug("Updated country:{}", updated);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Country not found for update", e);
		}
		LOGGER.info("End");
	}

	/**
	 * Bonus - find countries matching a partial name.
	 */
	private static void testFindCountriesByPartialName() {
		LOGGER.info("Start");
		List<Country> matches = countryService.findCountriesByPartialName("stan");
		LOGGER.debug("matches={}", matches);
		LOGGER.info("End");
	}

	/**
	 * Hands on 9 - delete the country added earlier.
	 */
	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("ZZ");
		LOGGER.info("End");
	}

}
