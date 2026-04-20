package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServieImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository; 

	@Override
	public List<BuildingDTO> findAll(String name, Integer numberOfBasement, List<String> typeCode) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(name, numberOfBasement, typeCode); 
		List<BuildingDTO> result = new ArrayList<BuildingDTO>(); 
		
		//Filter 
		for(BuildingEntity items : buildingEntities) {
			BuildingDTO building = new BuildingDTO(); 
			building.setName(items.getName()); 
			building.setNumberOfBasement(items.getNumberOfBasement()); 
			building.setAddress(items.getStreet() + ", " + items.getWard()); 
			result.add(building); 
		}
		return result; 
	}

}
