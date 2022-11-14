package com.siam.countries.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siam.countries.models.City;
import com.siam.countries.models.Country;
import com.siam.countries.services.ApiService;



@RestController
public class MainController {
	@Autowired
	ApiService apiService;
	

	
	@RequestMapping("/")
	public List<Object[]> index() {
//      1. What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language, and language percentage. Your query should arrange the result by language percentage in descending order.
		List<Object[]> countries = apiService.findCountriesByLanguage("Slovene");	
		

		return countries;
	}
//      2. What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order. 
		@RequestMapping("/cities")
		public List<Object[]> showCities() {
		List<Object[]> totalCities = apiService.findCountriesWithNumCities();
		
		return totalCities;
		}
// 		3. What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order. 
		@RequestMapping("/mexicancities")
		public List<City> showMexicanCities() {
		List<City> mexicanCities = apiService.findCitiesInCountryWithPopulationGreaterThan("Mexico", 500000);
		return mexicanCities;
		}
//
// 		4. What query would you run to get all languages in each country with a percentage greater than 89% ? Your query should arrange the result by percentage in descending order
		@RequestMapping("/langs")
		public List<Object[]> showAllLang(){
		List<Object[]> allLang = apiService.findLanguagesWithPercentageGreaterThan(89.0);
		return allLang;
		}
		
// 		5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000? 
		@RequestMapping("/surface")
		public List<Country> showAllcontriesWithSurface(){
		List<Country> countriesSurf = apiService.findCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(501.0, 100000);
		return countriesSurf;
		}
		
// 		 6. What query would you run to get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years? 
		@RequestMapping("/countries2")
		public List<Country> showContries2(){
		List<Country> countries2 = apiService.findCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan("Constitutional Monarchy", 200, 75.0);
		return countries2;
		}
		
// 		7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000?The query should return the Country Name, City Name, District, and Population. 
		@RequestMapping("/countries3")
		public List<Object[]> showContries3(){
		List<Object[]> countries3 = apiService.findCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(500000);
		return countries3;
		}
		
// 		 8. What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order
		@RequestMapping("/countries4")
		public List<Object[]> showContries4(){
		List<Object[]> countries4 = apiService.findNumberOfCountriesInEachRegion();
		return countries4;
		}
	
//		return "index.jsp";
	
}