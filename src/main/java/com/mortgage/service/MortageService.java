package com.mortgage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mortgage.entity.Application;

@Service
public interface MortageService {

	public List<Application> getAllApp();

}
