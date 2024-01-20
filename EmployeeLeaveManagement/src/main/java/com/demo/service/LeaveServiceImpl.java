package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LeaveDao;
import com.demo.model.Leavedetails;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	private LeaveDao ldao;

	@Override
	public List<Leavedetails> getAllLeave() {
		// TODO Auto-generated method stub
		return ldao.getAllLeave();
	}

	@Override
	public void insertleave(Leavedetails e) {
		ldao.insertleave(e);
		
	}

}
