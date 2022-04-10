package com.spring.boot.restapi;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Table(name = "project")
@RequestMapping("/api/project")
public class ProjectController{
	
	@Autowired
	private ProjectService projectService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	//Post method
	@PostMapping("/create")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result)
	{   
		     ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		     if(errorMap!=null) 
		     {
		    	return errorMap;
		     }			
	           	Project project1 = projectService.saveOrUpdateProject(project);
     		    return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
	
	//Update method
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProject(@Valid @RequestBody Project project, BindingResult result, @PathVariable("id") Long id)
	{       
		
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if(errorMap!=null) 
			{
				return errorMap;
			}	
			Project project1 = projectService.updateProject(project);
		    return new ResponseEntity<Project>(project1, HttpStatus.OK);
		    
	}	    
	
	//Delete Method
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProject(@Valid @RequestBody Project project, BindingResult result, @PathVariable("id") Long id)
	{       
		
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if(errorMap!=null) 
			{
				return errorMap;
			}	
		
			projectService.deleteProject(project);
		    return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
		    
	}	   
	
	//Get Method
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProject(@Valid @RequestBody Project project, BindingResult result, @PathVariable("id") Long id)
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if(errorMap!=null) 
			{
				return errorMap;
			}	
		
			Optional<Project> project1 = projectService.getProject(project);
		    return new ResponseEntity<Optional<Project>>(project1, HttpStatus.OK);
	}
	
}


			
