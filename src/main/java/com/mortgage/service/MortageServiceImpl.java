package com.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.entity.Application;
import com.mortgage.repository.ApplicationRepository;

@Service
public class MortageServiceImpl implements MortageService {
	@Autowired
	ApplicationRepository applicationRepository;

	@Override
	public List<Application> getAllApp() {
		List<Application> lst = new ArrayList<Application>();
		lst.addAll(applicationRepository.getDetailsBasedOnStatusNew());
		lst.addAll(applicationRepository.getDetailsBasedOnStatusApproved());
		lst.addAll(applicationRepository.getDetailsBasedOnStatusFunded());

		return lst;
	}

}
