package com.siam.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siam.projectmanager.models.Task;



@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAll();
	Optional<Task> findById(Long id);
	
	
}
