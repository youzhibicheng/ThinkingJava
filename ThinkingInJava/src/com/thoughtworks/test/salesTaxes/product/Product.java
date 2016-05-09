package com.thoughtworks.test.salesTaxes.product;

import com.thoughtworks.test.salesTaxes.util.DoubleUtil;

public class Product implements IProduct{
	private String name;
	private double price;
	private double tax;
	
	public Product(){
		this(null,0);
	}

	public Product(String name){
		this(name,0);
	}
	
	public Product(String name, double price){
		this(name,price,0);
	}
	
	public Product(String name, double price, double tax){
		this.setName(name);
		this.setPrice(price);
		this.setTax(tax);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public int getTaxRate(){
		return 0;
	}
	
	public String toString(){
		return getName() ;
	}

	@Override
	public double computeTax() {
		// TODO Auto-generated method stub
		return 0;
	}
}
