package com.mortgage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mortgage.entity.Application;

import com.mortgage.dto.ApplicationDto;

@Service
public interface MortageService {
	public ApplicationDto saveApplication(ApplicationDto applicationDto);

	public List<Application> getAllApp();

	public ApplicationDto searchApplicationById(Long applicationId);

}
