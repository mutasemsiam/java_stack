package com.siam.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siam.countries.models.City;
import com.siam.countries.models.Country;
import com.siam.countries.repositories.CityRepo;
import com.siam.countries.repositories.CountryRepo;
import com.siam.countries.repositories.LanguageRepo;


@Service
public class ApiService {
	
	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private LanguageRepo languageRepo;
	@Autowired
	private CityRepo cityRepo;
	
	public List<Country> allCountries(){
		return countryRepo.findAll();
	}
	
	public List<Object[]> findCountriesByLanguage(String language){
		return countryRepo.findCountriesByLanguageDesc(language);
	}
	
	public List<Object[]> findCountriesWithNumCities(){
		return countryRepo.findCountriesWithNumCities();
	}
	
	public List<City> findCitiesInCountryWithPopulationGreaterThan(String country, Integer population){
		return cityRepo.getMexicanCities(country, population);
	}
	
	public List<Object[]> findLanguagesWithPercentageGreaterThan(Double percentage){
		return countryRepo.findLanguagesWithPercentageGreaterThan(percentage);
	}
	
	public List<Country> findCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(Double surfaceArea, Integer population){
		return countryRepo.getCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(surfaceArea, population);
	}
	
	public List<Country> findCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan(String govermentForm, Integer capital, Double lifeExpectancy){
		return countryRepo.getCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan(govermentForm, capital, lifeExpectancy);
	}
	
	public List<Object[]> findCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(Integer population){
		return countryRepo.getCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(population);
	}
	
	public List<Object[]> findNumberOfCountriesInEachRegion(){
		return countryRepo.getNumberOfCountriesInEachRegion();
	}
	
}
