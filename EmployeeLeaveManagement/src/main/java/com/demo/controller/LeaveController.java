package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Leavedetails;
import com.demo.service.LeaveService;

@Controller
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	private LeaveService ls;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	 @GetMapping("/getleave")
	 public ModelAndView getleave(HttpSession session)
	 {
			 List<Leavedetails> list=ls.getAllLeave();
			 list.forEach(System.out::println);
			 return new ModelAndView("displayLeave","l",list);
	 }
	 
	 @GetMapping("/addLeave")
	 public String addnewEmployee(HttpSession ses) {
			 return "addLeave";
	 }
	 
	 @PostMapping("/insertleave")
	 public ModelAndView insertemployee(@RequestParam String empid,@RequestParam String startdate,@RequestParam String enddate,@RequestParam String leavetype,@RequestParam String leavereason) {
		 Leavedetails e=new Leavedetails(empid,startdate,enddate,leavetype,leavereason);
		 ls.insertleave(e);
		 return new ModelAndView("redirect:/leave/getleave");
	 }

}
