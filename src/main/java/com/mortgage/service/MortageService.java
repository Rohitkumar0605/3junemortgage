package com.mortgage.service;

import org.springframework.stereotype.Service;

import com.mortgage.dto.ApplicationDto;

@Service
public interface MortageService {
	public ApplicationDto saveApplication(ApplicationDto applicationDto);
}
