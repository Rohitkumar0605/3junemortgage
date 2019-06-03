package com.mortgage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1111111, allocationSize = 100)
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long applicationId;
	private String firstName;
	private String lastName;
	private String address;
	private double applicantIncome;
	private double loanAmount;
	private String status;
	private String creditStatus;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeCreated;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeModified;
	@Transient
	private String actionMessage;

	public Application() {
		super();
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getApplicantIncome() {
		return applicantIncome;
	}

	public void setApplicantIncome(double applicantIncome) {
		this.applicantIncome = applicantIncome;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getTimeModified() {
		return timeModified;
	}

	public void setTimeModified(Date timeModified) {
		this.timeModified = timeModified;
	}

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Address=" + address + ", applicantIncome=" + applicantIncome + ", loanAmount=" + loanAmount
				+ ", status=" + status + ", creditStatus=" + creditStatus + ", timeCreated=" + timeCreated
				+ ", timeModified=" + timeModified + "]";
	}

}
