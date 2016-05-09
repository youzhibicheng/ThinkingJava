package com.thoughtworks.test.salesTaxes.product;

public interface IProduct {
	public String getName();
	public void setName(String name);
	
	public double getPrice() ;
	public void setPrice(double price);
	
	public double getTax() ;
	public void setTax(double tax);
	
	public double computeTax();
	
	public String toString();
}
