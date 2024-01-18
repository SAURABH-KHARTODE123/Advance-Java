package com.demo.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyUser implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{
	private int uid;
	private String uname;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
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
	public void setUname(String uname) {
		System.out.println("in setter of uname");
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + "]";
	}
	public void setBeanName(String name) {
		System.out.println("in setBeanName method "+ name);
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("in setBeanFactory method");
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("in setApplicationContext method");
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("in afterPropertiesSet method");
	}
	
	public void myInit() {
		System.out.println("in custom init method");
	}
	public void destroy() throws Exception {
		System.out.println("in destroy method");
	}
	
	public void myDestroy() {
		System.out.println("in custom destroy method");
	}
	
	
}
