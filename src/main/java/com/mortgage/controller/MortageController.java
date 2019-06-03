package com.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.service.MortageService;

@RestController
public class MortageController {

	@Autowired
	private MortageService mortageService;
}
