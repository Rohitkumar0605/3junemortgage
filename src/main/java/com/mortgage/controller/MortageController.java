package com.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.entity.Application;
import com.mortgage.service.MortageService;

@RestController
public class MortageController {

	@Autowired
	private MortageService mortageService;

	@GetMapping("/getAllApplication")
	public List<Application> getAllApplication() {

		return mortageService.getAllApp();

	}
}
