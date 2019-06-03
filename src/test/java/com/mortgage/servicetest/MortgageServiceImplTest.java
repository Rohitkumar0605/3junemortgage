package com.mortgage.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mortgage.dto.ApplicationDto;
import com.mortgage.entity.Application;
import com.mortgage.repository.ApplicationRepository;
import com.mortgage.service.MortageServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MortgageServiceImplTest {

	@Mock
	ApplicationRepository appRepo;

	@InjectMocks
	MortageServiceImpl mortageServiceImpl;

	static ApplicationDto appDto = new ApplicationDto();
	static Application app = new Application();

	@BeforeClass
	public static void setUp() {

		appDto.setActionMessage("");
		appDto.setAddress("Thanjavur");
		appDto.setApplicantIncome(300000.00);
		appDto.setApplicationId(111L);
		appDto.setCreditStatus("Yes");
		appDto.setFirstName("kabilesh");
		appDto.setLastName("karthik");
		appDto.setLoanAmount(25000.00);
		appDto.setStatus("New");
		appDto.setTimeCreated(new Date());
		appDto.setTimeModified(new Date());

		app.setActionMessage("");
		app.setAddress(appDto.getAddress());
		app.setApplicantIncome(appDto.getApplicantIncome());
		app.setApplicationId(appDto.getApplicationId());
		app.setCreditStatus(appDto.getCreditStatus());
		app.setFirstName(appDto.getFirstName());
		app.setLastName(appDto.getLastName());
		app.setLoanAmount(appDto.getLoanAmount());
		app.setStatus(appDto.getStatus());
		app.setTimeCreated(appDto.getTimeCreated());
		app.setTimeModified(appDto.getTimeModified());

	}

	@Test
	public void saveApplicationTest() {
		Mockito.when(appRepo.save(app)).thenReturn(app);
		ApplicationDto actval1 = mortageServiceImpl.saveApplication(appDto);
		assertEquals(app.getFirstName(), actval1.getFirstName());
	}

}
