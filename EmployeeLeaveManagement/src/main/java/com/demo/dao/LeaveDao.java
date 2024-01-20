package com.demo.dao;

import java.util.List;

import com.demo.model.Leavedetails;

public interface LeaveDao {

	List<Leavedetails> getAllLeave();

	void insertleave(Leavedetails e);

}
