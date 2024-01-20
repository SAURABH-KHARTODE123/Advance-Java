package com.demo.service;

import java.util.List;

import com.demo.model.Leavedetails;

public interface LeaveService {

	List<Leavedetails> getAllLeave();

	void insertleave(Leavedetails e);

}
