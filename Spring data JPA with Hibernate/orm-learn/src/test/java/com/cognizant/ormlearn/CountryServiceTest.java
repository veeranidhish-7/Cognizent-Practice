package com.cognizant.ormlearn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootTest
class CountryServiceTest {

	@Autowired
	private CountryService countryService;

	@Test
	void contextLoads() {
		// application context (and CountryService bean) loaded successfully
	}

	@Test
	void addFindUpdateAndDeleteCountry() throws CountryNotFoundException {
		Country country = new Country("ZZ", "Testlandia");
		countryService.addCountry(country);

		Country found = countryService.findCountryByCode("ZZ");
		assertEquals("Testlandia", found.getName());

		countryService.updateCountry("ZZ", "Testlandia Updated");
		Country updated = countryService.findCountryByCode("ZZ");
		assertEquals("Testlandia Updated", updated.getName());

		countryService.deleteCountry("ZZ");
		assertThrows(CountryNotFoundException.class, () -> countryService.findCountryByCode("ZZ"));
	}

	@Test
	void findCountryByCodeThrowsWhenNotFound() {
		assertThrows(CountryNotFoundException.class, () -> countryService.findCountryByCode("XX"));
	}

	@Test
	void findCountriesByPartialNameIsCaseInsensitive() {
		countryService.addCountry(new Country("Y1", "Testonia"));
		countryService.addCountry(new Country("Y2", "Nottestable"));

		List<Country> matches = countryService.findCountriesByPartialName("test");

		assertFalse(matches.isEmpty());
		assertTrue(matches.stream().anyMatch(c -> c.getCode().equals("Y1")));
	}

}
