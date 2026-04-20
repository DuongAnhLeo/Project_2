package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	// Learning about JDBC in Java 
		// Driver to connect database
	static final String DB_URL = "jdbc:mysql://localhost:3306/estateadvance"; 
	static final String USER = "root"; 
	static final String PASS = "123456";

	@Override
	public List<BuildingEntity> findAll(String name, Integer numberOfBasement, List<String> typeCode) {  
		StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE 1 = 1"); 
		if (name != null && !name.equals("")) {
			sql.append(" And b.name like '%" + name + "%' "); 
		} 
		if (numberOfBasement != null) {
			sql.append(" And b.numberofbasement like " + numberOfBasement); 
		}
		List<BuildingEntity> result = new ArrayList<>(); 
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());){ 
			
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity(); 
				building.setName(rs.getString("name")); 
				building.setNumberOfBasement(rs.getInt("numberOfBasement")); 
				building.setWard(rs.getString("ward")); 
				building.setStreet(rs.getString("street")); 
				result.add(building); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return result;
	}
	
}
