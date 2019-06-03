package com.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.entity.Application;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.dto.ApplicationDto;

import com.mortgage.service.MortageService;

@RestController
public class MortageController {

	@Autowired
	private MortageService mortageService;

	@GetMapping("/getAllApplication")
	public List<Application> getAllApplication() {

		return mortageService.getAllApp();

	}

	@PostMapping("/saveApplication")
	public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto) {
		ApplicationDto appDto = mortageService.saveApplication(applicationDto);
		return new ResponseEntity<ApplicationDto>(appDto, HttpStatus.OK);
	}

	@GetMapping("/searchApplicationById/{applicationId}")
	public ResponseEntity<ApplicationDto> searchApplicationById(@PathVariable Long applicationId) {
		ApplicationDto appDto = mortageService.searchApplicationById(applicationId);
		return new ResponseEntity<ApplicationDto>(appDto, HttpStatus.OK);
	}

}
