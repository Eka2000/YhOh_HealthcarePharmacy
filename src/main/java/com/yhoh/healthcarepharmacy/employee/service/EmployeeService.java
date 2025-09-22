package com.yhoh.healthcarepharmacy.employee.service;

import java.util.List;

import com.yhoh.healthcarepharmacy.employee.dto.EmployeeRequest;
import com.yhoh.healthcarepharmacy.employee.dto.EmployeeResponse;

public interface EmployeeService {
	
    EmployeeResponse saveEmployee(EmployeeRequest dto);
    
    EmployeeResponse updateEmployee(String id, EmployeeRequest dto);
    
    EmployeeResponse getEmployeeById(String id);
    
    List<EmployeeResponse> getAllEmployees();
    
    void deleteEmployee(String id);
    
}