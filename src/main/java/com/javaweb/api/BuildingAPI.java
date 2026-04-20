package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

import customexception.FieldRequiredException;

// "@Controller" is a annotation, switch a java class to a restful api web service
// *Note: Param always use for only "searching", and Body use for another things. 
//@Controller
//"@ResponseBody" annotation use to return data have json type. If you don't want  write "@ResponseBody", let switch
//"@Controller" to "@RestController". You can remove "@Controller" forever 
@RestController 
public class BuildingAPI {	
// Check API: "@RequestMapping(value="api", method = RequestMethod.method)". If had API and method with front-end, switch to function getBuilding()
// If you don't want to use "@RequestMapping", let try "Method + Mapping", such as "@GetMapping(value = "api")"...
// Construction of "@RequestParam" is "@RequestParam(value= "variable", required = false or true)" 
	
	@Autowired
	private BuildingService buildingService; 
	
	@GetMapping(value = "/api/building/")
	public Object getBuiding(@RequestParam(name="name", required = false) String name,
							 @RequestParam(name="numberOfBasement", required = false) Integer numberOfBasement,
							 @RequestParam(name="typeCode", required = false) List<String> typeCode) {
//		try { test
//			valiDate(building); 
//		} catch (FieldRequiredException e) {
//			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(); 
//			errorResponseDTO.setError(e.getMessage()); 
//			List<String> detail = new ArrayList<>(); 
//			detail.add("Check again name or numberof basement, its is null!"); 
//			errorResponseDTO.setDetails(detail); 
//			return errorResponseDTO; 
//		}  
//		System.out.print(5/0); 
//		valiDate(building); 
//		System.out.print("The name of building is " + building.getName() + " and the number of building is " + building.getNumberOfBasement() ); 
		
		List<BuildingDTO> result = buildingService.findAll(name, numberOfBasement, typeCode); 
		
		return result;  
	}
	
//Map always use for Param, if you want to use Body, let try Java Bean 
//	@RequestMapping(value="/api/building/", method = RequestMethod.POST) 
//	public void getBuilding2(@RequestParam Map<String, String> params) { 
//		System.out.print(params);  
//	}
	
	//A Javabean will have constructed like a "Class"
	@PostMapping(value="/api/building/")
	public Object postBuiding() {
		
		try {
			System.out.print(5/0); 
		} catch (Exception e) {
			ErrorResponseDTO errorResponse = new ErrorResponseDTO(); 
			errorResponse.setError(e.getMessage()); 
			
			List<String> detail = new ArrayList<>(); 
			detail.add("Số nguyên làm sao chia cho 0 được"); 
			errorResponse.setDetails(detail); 
			return errorResponse; 
		} 
		
		List<BuildingDTO> listBuilding = new ArrayList<>();  	
		 
		return listBuilding; 
	}
	// "@PathVariable" have constructed like "@RequestParam", "{}" meaning is need to have in client (Param). Usually to delete 
	// and split right. 
	@DeleteMapping(value="/api/building/{id}/{name}")
	public void deleteBuiding(@PathVariable Integer id,
							  @PathVariable String name) {
		System.out.print("Done to remove " + id + " and " + name); 
	}
	
	// Build Error message, like constant message "/ by zero"
	// Error message: "name of number of basement is null""
	public void valiDate(BuildingDTO building) {
		if (building.getName() == null || building.getName().equals("") || building.getNumberOfBasement() == null) {
			throw new FieldRequiredException("name of number of basement is null"); 
		}
	}
} 
