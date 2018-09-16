package com.cts.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.dao.BookingSlotDAO;
import com.cts.vo.BookingSlotVO;

@Controller
public class BookingSlotController {
	
	@Autowired
	BookingSlotVO bookingSlotVO;
	
	@Autowired
	BookingSlotDAO bookingSlotDAO;

	public static Integer id = null;
	public static String message = null;
	
	@RequestMapping(value = "/book", method =  RequestMethod.GET)
	public String showBookingPage(ModelMap model){		
		model.addAttribute(bookingSlotVO);		
		return "booking";
	}
	
	@ModelAttribute("assessmentList")
	public Map<String,String> populateAssessmentList() {
		
		//Data referencing for java skills list box
		Map<String,String> assesmentList = new LinkedHashMap<String,String>();
		assesmentList.put("Spring 3.x Level1", "Spring 3.x CA Enablement Level1");
		assesmentList.put("Spring 3.x Level2", "Spring 3.x CA Enablement Level2");
		assesmentList.put("Spring 3.x Level3", "Spring 3.x CA Enablement Level3");
		assesmentList.put("Struts 2.x Level1", "Struts 2.x CA Enablement Level1");
		assesmentList.put("Struts 2.x Level2", "Struts 2.x CA Enablement Level2");
		assesmentList.put("Struts 2.x Level3", "Struts 2.x CA Enablement Level3");
		assesmentList.put("Hibernate 3.x Level1", "Hibernate 3.x CA Enablement Level1");
		assesmentList.put("Hibernate 3.x Level2", "Hibernate 3.x CA Enablement Level2");
		assesmentList.put("Hibernate 3.x Level3", "Hibernate 3.x CA Enablement Level3");
		assesmentList.put("JSF 1.x Level1", "JSF 1.x CA Enablement Level1");
		assesmentList.put("JSF 1.x Level2", "JSF 1.x CA Enablement Level2");
		assesmentList.put("JSF 1.x Level3", "JSF 1.x CA Enablement Level3");
		assesmentList.put("Core Java Level1", "Core Java CA Enablement Level1");
		assesmentList.put("Core Java Level2", "Core Java CA Enablement Level2");
		assesmentList.put("Core Java Level3", "Core Java CA Enablement Level3");
		assesmentList.put("Spring 3 MVC Level1", "Spring 3 MVC CA Enablement Level1");
		assesmentList.put("Spring 3 MVC Level2", "Spring 3 MVC CA Enablement Level2");
		assesmentList.put("Spring 3 MVC Level3", "Spring 3 MVC CA Enablement Level3");
		
		return assesmentList;
	}
	
	
	@ModelAttribute("levelList")
	public Map<String,String> populateLevelList() {
		
		//Data referencing for java skills list box
		Map<String,String> levelList = new LinkedHashMap<String,String>();
		levelList.put("Level1","Level1");
		levelList.put("Level2","Level2");
		levelList.put("Level3","Level3");
		
		return levelList;
	}
	
	@ModelAttribute("slotList")
	public Map<String,String> populatetimeSlotList() {
		
		//Data referencing for java skills list box
		Map<String,String> slotList = new LinkedHashMap<String,String>();
		slotList.put("10:00 AM","10:00 AM");
		slotList.put("12:00 PM","12:00 PM");
		slotList.put("02:00 PM","02:00 PM");
		slotList.put("04:00 PM","04:00 PM");
		slotList.put("06:00 PM","06:00 PM");
		
		return slotList;
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String confirmBookingDetails(
			@Valid BookingSlotVO bookingSlotVO,
			BindingResult bindingResult, Model model) {
		
		System.out.println(bookingSlotVO.getEmployeeId()+ " "
				+ bookingSlotVO.getEmployeeName() + " "
				+ bookingSlotVO.getEmail() + " "
				+ bookingSlotVO.getPhone() + " "
				+ bookingSlotVO.getAccountName() + " "
				+ bookingSlotVO.getAssessmentName()+ " "
				+ bookingSlotVO.getLevel()+ " "
				+ bookingSlotVO.getDateOfAssessment()+ " "
				+ bookingSlotVO.getSlot());
		
		if (bindingResult.hasErrors()) {
			System.out.println("Returning Booking.jsp ");
			return "booking";
		}
		System.out.println("Returning BookingSuccess.jsp page");
		try {
			
			
			
			id = bookingSlotDAO.confirmBookingSlot(bookingSlotVO);
			model.addAttribute("bookingId", id);
		} catch (Exception e) {
			message = e.getMessage();
			model.addAttribute("message", message);
			return "Failure";
		}
		return "bookingSuccess";
	}
}
