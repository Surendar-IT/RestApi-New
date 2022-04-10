package com.spring.boot.restapi;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
	public class ProjectService {
		
		@Autowired
		private ProjectRepository projectRepository;
		
		public Project saveOrUpdateProject(Project project) 
		{
			try{
				Optional<Project> prj = projectRepository.findById(project.getId());
				if(!(prj.isPresent() && prj.get().getId().equals(project.getId())))
				{	
				project.setEmailAddress(project.getEmailAddress().toUpperCase());
				return projectRepository.save(project);
				}	
				
				else {
					 throw new ProjectIdException("Exception occured ");
					 }
					  
		       }catch(Exception e) {
		    	  throw new ProjectIdException("Id " + project.getId()  + " already exist 2nd loop");
		       }
		}
		
		public Project updateProject(Project project) 
		{
			
			try{
				Optional<Project> prj = projectRepository.findById(project.getId());
				Project prj1 = prj.get();
				prj1.setEmailAddress(project.getEmailAddress().toUpperCase());
				return projectRepository.save(project);
		      }catch(Exception e) {
		    	  throw new ProjectIdException("Customer ID " + project.getId() + " not found ");
		      }
			}  	
		
		public void deleteProject(Project project) 
		{
			try{
				Optional<Project> prj = projectRepository.findById(project.getId());
				if((prj.isPresent() && prj.get().getId().equals(project.getId())))
				{				
				projectRepository.deleteById(project.getId());
				}	
				else {
					 throw new ProjectIdException("Id " + project.getId()  + " not found");
					 }
		       }catch(Exception e) {
		    	  throw new ProjectIdException("Id " + project.getId()  + " not found");
		       }
		}
		
		public Optional<Project> getProject(Project project) 
		{
			try{
				Optional<Project> prj = projectRepository.findById(project.getId());
				if((prj.isPresent() && prj.get().getId().equals(project.getId())))
				{
				return projectRepository.findById(project.getId());
				}
				else {
					 throw new ProjectIdException("Id " + project.getId()  + " not found");
					 }
		       }catch(Exception e) {
		    	  throw new ProjectIdException("Id " + project.getId()  + " not found");
		       }
			
		}

}