package com.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.dto.ApplicationDto;

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

	public ApplicationDto saveApplication(ApplicationDto applicationDto) {
		Application application = new Application();
		application.setFirstName(applicationDto.getFirstName());
		application.setLastName(applicationDto.getLastName());
		application.setAddress(applicationDto.getAddress());
		application.setApplicantIncome(applicationDto.getApplicantIncome());
		application.setCreditStatus(applicationDto.getCreditStatus());
		application.setTimeCreated(new Date());
		application.setTimeModified(new Date());
		application.setLoanAmount(applicationDto.getLoanAmount());
		application.setStatus("New");
		application.setActionMessage("");

		Application applic = applicationRepository.save(application);

		ApplicationDto appDto = new ApplicationDto();
		appDto.setApplicationId(applic.getApplicationId());
		appDto.setAddress(applic.getAddress());
		appDto.setApplicantIncome(applic.getApplicantIncome());
		appDto.setCreditStatus(applic.getCreditStatus());
		appDto.setFirstName(applic.getFirstName());
		appDto.setLastName(applic.getLastName());
		appDto.setLoanAmount(applic.getLoanAmount());
		appDto.setStatus(applic.getStatus());
		appDto.setTimeCreated(applic.getTimeCreated());
		appDto.setTimeModified(applic.getTimeModified());
		appDto.setActionMessage(applic.getActionMessage());

		return appDto;
	}

	@Override
	public ApplicationDto searchApplicationById(Long applicationId) {
		Application applic = applicationRepository.findById(applicationId).get();

		ApplicationDto appDto = new ApplicationDto();

		appDto.setApplicationId(applic.getApplicationId());
		appDto.setAddress(applic.getAddress());
		appDto.setApplicantIncome(applic.getApplicantIncome());
		appDto.setCreditStatus(applic.getCreditStatus());
		appDto.setFirstName(applic.getFirstName());
		appDto.setLastName(applic.getLastName());
		appDto.setLoanAmount(applic.getLoanAmount());
		appDto.setStatus(applic.getStatus());
		appDto.setTimeCreated(applic.getTimeCreated());
		appDto.setTimeModified(applic.getTimeModified());
		appDto.setActionMessage(applic.getActionMessage());

		return appDto;

	}

}
