package com.siam.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siam.projectmanager.models.Project;
import com.siam.projectmanager.repositories.ProjectRepository;



@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepo;
	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteProject(Long id) {
		
		projectRepo.deleteById(id);
	}
	
	public Project updateProject(Project project) {

		return projectRepo.save(project);
	}
	
	//retrieve unjoined projects
	public List<Project> unJoinedProjects(Long memberId){
		return projectRepo.getUnJoinedProjects(memberId);

	}
	
	//OR
//	public List<Project> unJoinedProjects(User user){
//		return projectRepo.findByMembersNotContains(user);
//
//	}
	
	//retrieve joined projects
	public List<Project> joinedProjects(Long leadId){
		return projectRepo.getJoinedProjects(leadId);

	}
	
	//OR
//	public List<Project> joinedProjects(User user){
//		return projectRepo.findByMembersContains(user);
//
//	}

}
