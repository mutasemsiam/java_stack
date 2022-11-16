package com.siam.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.siam.projectmanager.models.Project;
//import com.siam.projectmanager.models.User;



@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	Optional<Project> findById(Long id);
	
	// find unjoined projects(user has not created nor joined)
		@Query(value = "SELECT * FROM projects JOIN users_projects ON projects.id = users_projects.project_id\r\n"
				+ "WHERE users_projects.project_id NOT IN (SELECT project_id FROM users_projects WHERE member_id=?1);", 
				  nativeQuery = true)
		List<Project> getUnJoinedProjects(Long member_id);

	//	Or we can use this simple query to get the same result as the above one(find unjoined projects):
	//	List<Project> findByMembersNotContains(User user);
	
		
	//find joined projects(either user created or joined)
	@Query(value = "SELECT * FROM projects JOIN users_projects ON projects.id = users_projects.project_id \r\n"
			+ "WHERE users_projects.member_id = ?1", 
			  nativeQuery = true)
	List<Project> getJoinedProjects(Long lead_id);
	
	//  OR(joined projects):
	//	List<Project> findByMembersContains(User user);
	//
	//(Members) refers to the field (members) in the Project Class model
	
	
}
