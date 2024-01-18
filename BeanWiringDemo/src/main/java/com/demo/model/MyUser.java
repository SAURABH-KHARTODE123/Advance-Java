package com.demo.model;

public class MyUser {
	private int uid;
	private String uname;
	private Address addr;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String uname, Address addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.addr = addr;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in setter of uid");
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public void setUname(String uname) {
		System.out.println("in setter of uname");
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + " addr=" + addr + "]";
	}
	
}
