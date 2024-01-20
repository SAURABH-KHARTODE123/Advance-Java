package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Leavedetails;

@Repository
public class LeaveDaoImpl implements LeaveDao{

	@Autowired
	JdbcTemplate jt;

	@Override
	public List<Leavedetails> getAllLeave() {
		return jt.query("select * from leavedetails",BeanPropertyRowMapper.newInstance(Leavedetails.class));
	}

	@Override
	public void insertleave(Leavedetails e) {
		String s="insert into leavedetails values(?,?,?,?,?)";
		jt.update(s,new Object[] {e.getLeave_id(),e.getStart_on(),e.getEnd_on(),e.getLeave_type(),e.getLeave_reason()});
		
	}

}
