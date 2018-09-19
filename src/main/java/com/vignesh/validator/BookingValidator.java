package com.vignesh.validator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vignesh.dao.BookingSlotDAO;
import com.vignesh.vo.BookingSlotVO;

@Component
public class BookingValidator implements Validator{
	
	@Autowired
	private BookingSlotDAO bookingSlotDAO;	

	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		// just validate the Customer instances
		return BookingSlotVO.class.isAssignableFrom(clazz);

	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId",
				"required.employeeId", "Employee Id is required!");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeName",
				"required.employeeName", "Employee Name is required!");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
				"required.phone", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountName",
				"required.accountName", "Field name is required!");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "assessmentName",
				"required.assessmentName", "Field name  is required!");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "level",
				"required.level", "Field name is required!");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "slot",
				"required.slot", "Field name is required.");

	

	//*************************************************************************************************************
		BookingSlotVO detailsVO = (BookingSlotVO) target;

		
				
		if(!(detailsVO.getEmployeeId().equals("") ||detailsVO.getEmployeeId().equals(null)) ){
			///^[a-zA-Z ]{2,30}$/
				if (!(detailsVO.getEmployeeId().matches("\\d{6}"))) {
				errors.rejectValue("employeeId", "invalid.employeeId");
			}
			}
		
		if(!(detailsVO.getEmployeeName().equals("") ||detailsVO.getEmployeeName().equals(null)) ){
		///^[a-zA-Z ]{2,30}$/
			if (!(detailsVO.getEmployeeName().matches("^[a-zA-Z\\s]{2,30}$"))) {
			errors.rejectValue("employeeName", "invalid.employeeName");
		}
		}
		
		if(!(detailsVO.getEmail().equals("") ||detailsVO.getEmail().equals(null)) ){
		if(!(detailsVO.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))){
			errors.rejectValue("email", "invalid.email");
		}
		}
		
		if(!(detailsVO.getPhone().equals("") ||detailsVO.getPhone().equals(null)) ){
			if (!(detailsVO.getPhone().matches("\\d{10}"))) {
				errors.rejectValue("phone", "phone.format");
			}
			}
		

		if (detailsVO.getDateOfAssessment() == null) {
			errors.rejectValue("dateOfAssessment", "required.dateOfAssessment");
		}
		
		
		if (detailsVO.getDateOfAssessment() != null) {

			Date date = (Date) detailsVO.getDateOfAssessment();
			Date date1 = new Date();

			if (date.before(date1)) {
				errors.rejectValue("dateOfAssessment", "before.dateOfAssessment");
			}

		}
		
		if(detailsVO.getEmployeeId()!=null && detailsVO.getAssessmentName()!=null && detailsVO.getLevel() != null){
				
			  
	  		  
			  if(!(bookingSlotDAO.checkAssesmentNameAndLevel(detailsVO.getEmployeeId(),detailsVO.getAssessmentName(),detailsVO.getLevel()))){
					errors.rejectValue("assessmentName", "assessmentName.blocked");
				}
		
		
		}
		
	  if(detailsVO.getEmployeeId()!=null && detailsVO.getSlot()!=null && detailsVO.getDateOfAssessment() != null){
		  
		  
		  		  
		  if(!(bookingSlotDAO.checkDateAndTimeSlot(detailsVO.getEmployeeId(),detailsVO.getDateOfAssessment(),detailsVO.getSlot()))){
				errors.rejectValue("slot", "slot.blocked");
			}
		  
		  
	  }	
	

	}

}
