package com.siam.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.siam.countries.models.Country;



public interface CountryRepo extends CrudRepository<Country, Long>{
	
	List<Country> findAll();
	
//	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE language = ?1 ORDER BY percentage DESC")
//	List<Object[]> findCountriesByLanguageDesc(String language);
	@Query(value = "SELECT countries.name,languages.language, languages.percentage FROM countries\r\n"
			+ "JOIN languages ON countries.id = languages.country_id\r\n"
			+ "WHERE language = ?1 \r\n"
			+ "ORDER BY percentage DESC;", nativeQuery = true )
	List<Object[]> findCountriesByLanguageDesc(String language);
	
//	@Query("SELECT c.name, COUNT(c.id) AS numberOfCities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY numberOfCities DESC")
//	List<Object[]> findCountriesWithNumCities();
	@Query(value = "SELECT countries.id,countries.name as country, count(cities.name) as number_of_cities FROM countries\r\n"
			+ "JOIN cities ON countries.id = cities.country_id\r\n"
			+ "GROUP BY countries.name\r\n"
			+ "ORDER BY number_of_cities DESC;", nativeQuery = true)
	List<Object[]> findCountriesWithNumCities();
	
//	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >= ?1 ORDER BY l.percentage DESC")
//	List<Object[]> findLanguagesWithPercentageGreaterThan(Double percentage);
	@Query(value="SELECT countries.id, countries.name AS country, languages.language, languages.percentage  FROM countries\r\n"
			+ "JOIN languages ON countries.id = languages.country_id\r\n"
			+ "WHERE languages.percentage> ?1 \r\n"
			+ "ORDER BY languages.percentage DESC;", nativeQuery= true)
	List<Object[]> findLanguagesWithPercentageGreaterThan(Double percentage);
	
//	@Query("SELECT c FROM Country c WHERE c.surfaceArea < ?1 AND c.population > ?2")
//	List<Country> findCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(Double surfaceArea, Integer population);
	
	@Query(value = "SELECT countries.id, countries.name AS country, countries.surface_area, countries.population FROM countries\r\n"
			+ "WHERE countries.surface_area< ?1 AND countries.population> ?2 ;", nativeQuery= true)
	List<Country> getCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(Double surfaceArea, Integer population);
	
//	@Query("SELECT c FROM Country c WHERE c.governmentForm = ?1 AND c.capital > ?2 AND c.lifeExpectancy > ?3")
//	List<Country> findCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan(String govermentForm, Integer capital, Double lifeExpectancy);
	
	@Query(value= "SELECT countries.id, countries.name AS country, countries.government_form, countries.capital, \r\n"
			+ "countries.life_expectancy FROM countries\r\n"
			+ "WHERE countries.government_form = ?1 AND countries.capital> ?2 AND \r\n"
			+ "countries.life_expectancy> ?3 ;", nativeQuery=true)
	List<Country> getCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan(String govermentForm, Integer capital, Double lifeExpectancy);
	
	
//	@Query("SELECT c.name, ci.name, ci.district, ci.population FROM Country c JOIN c.cities ci WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > ?1")
//	List<Object[]> findCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(Integer population);
	
	@Query(value = "SELECT countries.name AS country_name, cities.name AS city_name, cities.district, cities.population from countries\r\n"
			+ "JOIN cities ON countries.id = cities.country_id\r\n"
			+ "WHERE countries.name = 'argentina' AND cities.district = 'buenos aires' AND cities.population> ?1;", nativeQuery=true)
	List<Object[]> getCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(Integer population);
	
	
//	@Query("SELECT c.region, COUNT(c.id) AS numberOfCountries FROM Country c GROUP BY c.region ORDER BY numberOfCountries DESC")
//	List<Object[]> findNumberOfCountriesInEachRegion();
	
	@Query(value = "SELECT countries.region AS Region_name, count(countries.name) AS Number_of_countries from countries\r\n"
			+ "GROUP BY countries.region\r\n"
			+ "ORDER BY Number_of_countries DESC;", nativeQuery = true)
	List<Object[]> getNumberOfCountriesInEachRegion();
}