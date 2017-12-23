package com.javagain.kafkademo.producerexample;

import java.util.Date;

public class Supplier {
	
	private int id;
	private String supplierName;
	private Date startDate;
	public Supplier(int id, String supplierName, Date startDate) {
		this.id = id;
		this.supplierName = supplierName;
		this.startDate = startDate;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	

}
