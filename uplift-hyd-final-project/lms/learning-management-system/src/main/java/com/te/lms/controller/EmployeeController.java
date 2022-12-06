package com.te.lms.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.RegistrationDto;
import com.te.lms.dto.UpdateDto;
import com.te.lms.response.RegistrationResponse;
import com.te.lms.service.EmployeeService;
import com.te.lms.service.RequestListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/public")
public class EmployeeController {
	
	private final EmployeeService employeeService;	
	private final RequestListService requestListService;
	
	@PostMapping(path = "/employee/register")
	public RegistrationResponse<String> employeeRegister(@RequestBody RegistrationDto registrationDto){
		
		Optional<String> optionalEmployeeId = employeeService.register(registrationDto);
		if(optionalEmployeeId.isPresent()) {
			requestListService.addToList(optionalEmployeeId.get());
		}
		return new RegistrationResponse<String>("Your Request will be Approved in Sometime please wait.....!");
	}
	
	@RequestMapping(path = "/update/{empId}")
	public RegistrationResponse<String> update(@RequestBody UpdateDto updateDto, @PathVariable(name = "empId") String empId){
		
		Optional<Boolean> updateEmployee = employeeService.update(empId,updateDto);
		
		return new RegistrationResponse<String>("employee is updated successfully");
	}
}

