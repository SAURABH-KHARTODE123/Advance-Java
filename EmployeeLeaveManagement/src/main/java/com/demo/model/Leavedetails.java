package com.demo.model;

public class Leavedetails {

	private String leave_id;
	private String start_on;
	private String end_on;
	private String leave_type;
	private String leave_reason;
	public Leavedetails() {
		super();
	}
	public Leavedetails(String leave_id, String start_on, String end_on, String leave_type, String leave_reason) {
		super();
		this.leave_id = leave_id;
		this.start_on = start_on;
		this.end_on = end_on;
		this.leave_type = leave_type;
		this.leave_reason = leave_reason;
	}
	public String getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(String leave_id) {
		this.leave_id = leave_id;
	}
	public String getStart_on() {
		return start_on;
	}
	public void setStart_on(String start_on) {
		this.start_on = start_on;
	}
	public String getEnd_on() {
		return end_on;
	}
	public void setEnd_on(String end_on) {
		this.end_on = end_on;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public String getLeave_reason() {
		return leave_reason;
	}
	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}
	@Override
	public String toString() {
		return "Leavedetails [leave_id=" + leave_id + ", start_on=" + start_on + ", end_on=" + end_on + ", leave_type="
				+ leave_type + ", leave_reason=" + leave_reason + "]";
	}
	
	

}
