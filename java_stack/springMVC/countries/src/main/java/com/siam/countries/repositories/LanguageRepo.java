package com.siam.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.siam.countries.models.Language;

public interface LanguageRepo extends CrudRepository<Language, Long> {

}
