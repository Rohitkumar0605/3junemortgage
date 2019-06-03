package com.mortgage.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.dto.ApplicationDto;
import com.mortgage.service.MortageService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MortageController {

	@Autowired
	private MortageService mortageService;

	@PostMapping("/saveApplication")
	public ResponseEntity<ApplicationDto> saveApplication(@RequestBody ApplicationDto applicationDto) {
		ApplicationDto appDto = mortageService.saveApplication(applicationDto);
		if (null != appDto) {
			appDto.setStatusCode(200);
			appDto.setStatusMessage("success");
			return new ResponseEntity<ApplicationDto>(appDto, HttpStatus.OK);
		} else {
			appDto.setStatusCode(403);
			appDto.setStatusMessage("failure");
			return new ResponseEntity<ApplicationDto>(appDto, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/searchApplicationById/{applicationId}")
	public ResponseEntity<ApplicationDto> searchApplicationById(@PathVariable Long applicationId) {
		ApplicationDto appDto = mortageService.searchApplicationById(applicationId);
		if (null != appDto) {
			appDto.setStatusCode(200);
			appDto.setStatusMessage("success");
			return new ResponseEntity<ApplicationDto>(appDto, HttpStatus.OK);
		} else {
			appDto.setStatusCode(403);
			appDto.setStatusMessage("failure");
			return new ResponseEntity<ApplicationDto>(appDto, HttpStatus.BAD_REQUEST);
		}
	}

}
