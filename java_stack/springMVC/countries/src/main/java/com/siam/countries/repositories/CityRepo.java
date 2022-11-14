package com.siam.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.siam.countries.models.City;


public interface CityRepo extends CrudRepository<City, Long>{
	@Query(value = "SELECT countries.id, countries.name AS country, cities.name AS city, cities.population FROM countries\r\n"
			+ "JOIN cities ON countries.id = cities.country_id\r\n"
			+ "WHERE countries.name = ?1 AND cities.population> ?2 \r\n"
			+ "ORDER BY cities.population DESC;", nativeQuery = true)
	List<City> getMexicanCities(String country, Integer population);
}