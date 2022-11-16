package com.siam.projectmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.siam.projectmanager.models.LoginUser;
import com.siam.projectmanager.models.Project;
import com.siam.projectmanager.models.User;
import com.siam.projectmanager.services.ProjectService;
import com.siam.projectmanager.services.TaskService;
import com.siam.projectmanager.services.UserService;

@Controller
public class MainController {
	
	 @Autowired
     UserService userService;
	 @Autowired
	 ProjectService projectService;
	 @Autowired
	 TaskService taskService;
	 
	 @GetMapping("/")
	    public String index(Model model, HttpSession session) {
	    	
	        if(session.getAttribute("userId")!= null) {
	        	return "redirect:/dashboard";
	        }
	    	
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "login_reg.jsp";
	    }
	 
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser,
	    		               BindingResult result, HttpSession session, Model model) {
		     
			User user = userService.register(newUser, result);
			
		    if(result.hasErrors()) {
		        model.addAttribute("newLogin", new LoginUser());
		        return "login_reg.jsp";
		    }
		    
		    session.setAttribute("userId", user.getId());
		 
		    return "redirect:/dashboard";
		
	        }

	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	                        BindingResult result, Model model, HttpSession session) {
	        
	       
	         User user = userService.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "login_reg.jsp";
	        }
	    
	        session.setAttribute("userId", user.getId());
	    
	        return "redirect:/dashboard";
	    }
	    
		@GetMapping("/logout")
		public String logout(HttpSession session) {
		 
			session.invalidate();
		     
		    return "redirect:/";
		}
		
		@GetMapping("/dashboard")
		public String home(HttpSession session, Model model) {
			if(session.getAttribute("userId")== null) {
				return "redirect:/";
			}
			
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("currentUser", userService.findUserById(userId));
			model.addAttribute("projects", projectService.allProjects());
			
//			User currentUser = userService.findUserById(userId);
//			model.addAttribute("unjoinedProjects", projectService.unJoinedProjects(currentUser));
			
			model.addAttribute("unjoinedProjects", projectService.unJoinedProjects(userId));
			model.addAttribute("joinedProjects", projectService.joinedProjects(userId));
	
			return "dashboard.jsp";
		}
		
		@GetMapping("/projects/new")
		public String newProject(@ModelAttribute("project") Project project) {
			
			return "new.jsp";
		}
		
		@PostMapping("/projects/new")
		public String createNewProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
				HttpSession session, Model model) {
			
			if(result.hasErrors()) {
				return "new.jsp";
			}
			Long userId = (Long) session.getAttribute("userId");
			User currentUser = userService.findUserById(userId);
			project.setLead(currentUser);		
			projectService.createProject(project);
//			List<User> members = new ArrayList<User>();
//			members.add(currentUser);
//			project.setMembers(members);
			
//			project.getMembers().add(currentUser);
//			projectService.updateProject(project);
			currentUser.getProjects().add(project);
			userService.updateUser(currentUser);
			return "redirect:/dashboard";
		}
		
		@GetMapping("/projects/{id}/edit")
		public String edit(@PathVariable("id")Long id, Model model) {
			Project project = projectService.findProject(id);
			model.addAttribute("project", project);
			return"edit.jsp";
		}
		
		@PutMapping("/projects/{id}/edit")
		public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result, @PathVariable("id")Long id,HttpSession session) {
			if (result.hasErrors()) {
				return "edit.jsp";
			}
		
			Long userId = (Long) session.getAttribute("userId");
			User currentUser = userService.findUserById(userId);
			project.setLead(currentUser);	
			
			Project thisProject = projectService.findProject(id);
			project.setMembers(thisProject.getMembers());
			
			
			projectService.updateProject(project);
			return "redirect:/dashboard";
		}
		
		@GetMapping("/join/{id}")
		public String joinProject(@PathVariable("id") Long id, HttpSession session) {
			
			Long userId = (Long) session.getAttribute("userId");
			User currentUser = userService.findUserById(userId);
			Project project = projectService.findProject(id);
//			project.getUsers().add(currentUser);
//			projectService.updateProject(project);			
		
			currentUser.getProjects().add(project);
			userService.updateUser(currentUser);

			
			return "redirect:/dashboard";
		}
		
		@GetMapping("/leave/{id}")
		public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
			
			Long userId = (Long) session.getAttribute("userId");
			User currentUser = userService.findUserById(userId);
			Project project = projectService.findProject(id);		
		
			currentUser.getProjects().remove(project);
			userService.updateUser(currentUser);

			
			return "redirect:/dashboard";
		}
			
		  @GetMapping("/projects/{projId}")
		  public String showProject(@PathVariable("projId") Long PId,HttpSession session, Model model) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
	    	}
			
			model.addAttribute("project", projectService.findProject(PId));
		  	
		  	return "show_project.jsp";
}
		  
		  @GetMapping("/delete/{projectId}")
		    public String deleteProject(@PathVariable("projectId") Long PId, HttpSession session) {
		    	if(session.getAttribute("userId") == null) {
					return "redirect:/";
		    	}
		    	
		    	Project project = projectService.findProject(PId);
		    	if(session.getAttribute("userId")==project.getLead().getId()) {
		    	projectService.deleteProject(PId);
		    	}
		    	return "redirect:/dashboard";
		    }
}
