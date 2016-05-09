package com.thoughtworks.test.salesTaxes.product;

import com.thoughtworks.test.salesTaxes.handler.ITaxHandler;
import com.thoughtworks.test.salesTaxes.handler.TaxHandlerFactory;
import com.thoughtworks.test.salesTaxes.util.DoubleUtil;

public class BasicProductDecorator extends ProductDecorator {
	private static final int TAX_RATE=10;
	
	public BasicProductDecorator(IProduct product){
		super(product);
	}
	
	@Override
	public double computeTax() {
		
		double result = ( getPrice() * TAX_RATE / 100 ) + super.product.computeTax();
		
		//you can choose different compute method for every product decorator
		ITaxHandler cs = TaxHandlerFactory.getTaxHandler("1");
		setTax( cs.handleTax(result) );
		
		return result;
	}
	
	public String toString(){
		return getName() ;
	}
}
