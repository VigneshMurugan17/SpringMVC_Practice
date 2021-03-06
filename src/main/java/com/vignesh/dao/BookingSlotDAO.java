package com.vignesh.dao;

import java.util.Date;
import java.util.List;

import com.vignesh.vo.BookingSlotVO;

public interface BookingSlotDAO {
	public boolean checkDateAndTimeSlot(String employeeId, Date dateOfAssessment, String timeSlot);
	
	public boolean checkAssesmentNameAndLevel(String employeeId, String assessmentName, String level);
	
	public Integer confirmBookingSlot(BookingSlotVO vo);
	
	public List<BookingSlotVO> showBookingSlots();
	
	

}
