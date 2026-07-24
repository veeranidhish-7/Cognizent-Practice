package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) context.getBean("countryList", List.class);
		LOGGER.debug("Country list: {}", countryList);
		LOGGER.info("END");
		return countryList;
	}

	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.info("START");
		LOGGER.debug("code: {}", code);

		List<Country> countryList = getAllCountries();

		Country result = countryList.stream()
				.filter(country -> country.getCode().equalsIgnoreCase(code))
				.findFirst()
				.orElseThrow(() -> new CountryNotFoundException("Country not found"));

		LOGGER.debug("result: {}", result);
		LOGGER.info("END");
		return result;
	}

}
