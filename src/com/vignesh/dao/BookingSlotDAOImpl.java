package com.vignesh.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.vignesh.model.BookingSlot;
import com.vignesh.vo.BookingSlotVO;

public class BookingSlotDAOImpl implements BookingSlotDAO {

	@Autowired
	DataSource dataSource;

	/*
	 * (non-Javadoc)
	 * @see confirmBookingSlot(BookingSlotVO vo)
	 * This method will insert the records into the BookingSlot table in the database  and return the bookingId
	 */
	public Integer confirmBookingSlot(BookingSlotVO vo) {

		String sql = "INSERT INTO BookingSlot (employeeId,employeeName, email,phone,accountName,assessmentName,level,dateofAssessment,slot)"
				+ " VALUES (?, ?, ?,?,?,?,?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, vo.getEmployeeId(), vo.getEmployeeName(),
				vo.getEmail(), vo.getPhone(), vo.getAccountName(),
				vo.getAssessmentName(), vo.getLevel(),
				vo.getDateOfAssessment(), vo.getSlot());

		System.out.println("Data inserted successfully");

		String sql1 = "SELECT * FROM BookingSlot ";

		List<BookingSlot> bookingSlotList = jdbcTemplate.query(sql1,
				new BookingSlotRowMapper());

		int size = bookingSlotList.size();

		return bookingSlotList.get(size - 1).getBookingId();

	}

	/*
	 * (non-Javadoc)
	 * @see List<BookingSlotVO> showBookingSlots()
	 * This method will return the complete list of slot booked for assessments.
	 */
	public List<BookingSlotVO> showBookingSlots() {
		List<BookingSlotVO> bookingList = new ArrayList<BookingSlotVO>();
		String sql = "SELECT * FROM BookingSlot";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<BookingSlot> listBookingDetails = jdbcTemplate.query(sql,
				new BookingSlotRowMapper());

		Iterator<BookingSlot> iterator = listBookingDetails.iterator();
		while (iterator.hasNext()) {

			BookingSlot bd = (BookingSlot) iterator.next();

			BookingSlotVO vo = new BookingSlotVO();

			vo.setBookingId(bd.getBookingId());
			vo.setEmployeeId(bd.getEmployeeId());
			vo.setEmployeeName(bd.getEmployeeName());
			vo.setEmail(bd.getEmail());
			vo.setPhone(bd.getPhone());
			vo.setAccountName(bd.getAccountName());
			vo.setAssessmentName(bd.getAssessmentName());
			vo.setLevel(bd.getLevel());
			vo.setDateOfAssessment(bd.getDateOfAssessment());
			vo.setSlot(bd.getSlot());
						
			bookingList.add(vo);

		}
		return bookingList;
	}

	/*
	 * (non-Javadoc)
	 * @see boolean checkDateAndTimeSlot(String employeeId ,Date dateOfAssessment, String timeSlot)
	 * This method will check if there is already a booking done for the same date and time slot. If yes it will return FALSE
	 */
	public boolean checkDateAndTimeSlot(String employeeId ,Date dateOfAssessment, String timeSlot) {
		
		Date utilDate =dateOfAssessment;
		  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		System.out.println("Employee Id "+employeeId);
		System.out.println("Date Of Assessment "+dateOfAssessment);
		System.out.println("Slot  "+timeSlot);
		
		String sql = "SELECT * FROM BookingSlot where dateOfAssessment = '"+sqlDate+"'  and slot = '"+timeSlot+"'  and employeeId = '"+employeeId+"'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<BookingSlot> listBookingDetails = jdbcTemplate.query(sql,
				new BookingSlotRowMapper());
				
		System.out.println("listBookingDetails.size "+listBookingDetails.size());
		if(listBookingDetails.size()>0){
		return false;
		}
		return true;
		
	}

	/*
	 * (non-Javadoc)
	 * boolean checkAssesmentNameAndLevel(String employeeId,String assessmentName, String level) 
	 * This method will check if the assessmentName and level is lready booked.If yes it will return false		
	 */
	public boolean checkAssesmentNameAndLevel(String employeeId,
			String assessmentName, String level) {
		
		System.out.println("Employee Id "+employeeId);
		System.out.println("Assessment Name"+assessmentName);
		System.out.println("Level  "+level);
		
		String sql = "SELECT * FROM BookingSlot where assessmentName = '"+assessmentName+"'  and level = '"+level+"'  and employeeId = '"+employeeId+"'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<BookingSlot> listBookingDetails = jdbcTemplate.query(sql,
				new BookingSlotRowMapper());
				
		System.out.println("listBookingDetails.size "+listBookingDetails.size());
		if(listBookingDetails.size()>0){
		return false;
		}
		return true;
	}

	



}
