package com.siam.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siam.projectmanager.models.Task;
import com.siam.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepo;
	
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}

}
