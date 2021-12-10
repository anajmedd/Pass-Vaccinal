package com.matrixidentity.passvaccinal.webservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrixidentity.passvaccinal.dto.CheckPassRequestDto;
import com.matrixidentity.passvaccinal.dto.CheckPassResponseDto;
import com.matrixidentity.passvaccinal.entities.Person;
import com.matrixidentity.passvaccinal.service.PassVaccinalService;

@RestController
@RequestMapping("PassVaccinalApi")
public class PassVaccinalApi {
	@Autowired
	PassVaccinalService passVaccinalService;
    
	@GetMapping("test")
	public String test() {
		return "OK";
	}

	@PostMapping("check")
	public CheckPassResponseDto checkPass(@RequestBody CheckPassRequestDto requestDto) {
		CheckPassResponseDto checkPassResponseDto = new CheckPassResponseDto();
		checkPassResponseDto.fullName = requestDto.firstName +" "+ requestDto.lastName;
		return checkPassResponseDto;
	}
	@PostMapping("afficher")
	public Person afficherPass(@RequestBody CheckPassRequestDto requestDto) {
		
		return passVaccinalService.afficherPass(requestDto);
		
	}
}
