package com.thoughtworks.test.salesTaxes.product;

public class ProductDecorator implements IProduct{
	IProduct product;
	
	ProductDecorator(IProduct product){
		this.product = product;
	}

	@Override
	public String getName() {
		return product.getName();
	}

	@Override
	public double getPrice() {
		return product.getPrice();
	}

	@Override
	public double getTax() {
		return product.getTax();
	}

	@Override
	public void setName(String name) {
		product.setName(name);
	}

	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTax(double tax) {
		product.setTax(tax);
	}

	@Override
	public double computeTax() {
		// TODO Auto-generated method stub
		return 0;
	}

}
