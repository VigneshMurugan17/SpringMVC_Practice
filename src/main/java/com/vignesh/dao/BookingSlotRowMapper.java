package com.vignesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vignesh.model.BookingSlot;

public class BookingSlotRowMapper implements RowMapper<BookingSlot>{
	
	public BookingSlot mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookingSlot bookingDetails = new BookingSlot();
		bookingDetails.setBookingId(rs.getInt("bookingId"));
		bookingDetails.setEmployeeId(rs.getString("employeeId"));
		bookingDetails.setEmployeeName(rs.getString("employeeName"));
		bookingDetails.setEmail(rs.getString("email"));
		bookingDetails.setPhone(rs.getString("phone"));
		bookingDetails.setAccountName(rs.getString("accountName"));
		bookingDetails.setAssessmentName(rs.getString("assessmentName"));
		bookingDetails.setLevel(rs.getString("level"));
		bookingDetails.setDateOfAssessment(rs.getDate("dateOfAssessment"));
		bookingDetails.setSlot(rs.getString("slot"));
		
		return bookingDetails;
	}

}
