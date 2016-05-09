package com.thoughtworks.test.salesTaxes.handler;

public class TaxHandler1 implements ITaxHandler {
	/*
	 * The rounding rules for sales tax are that for a tax rate of n%, 
	 * a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.
	 * */
	public double handleTax(double tax ){
		if( tax == 0 ){
			return 0;
		}else if( tax * 100 % 10 == 0 ){		//3.102->3.10
			return tax;
		}else if( tax * 100 % 10 < 5 ){	//3.146->3.15
			return (Math.floor(tax * 10)+0.5)/10;
		}else{								//3.153->3.20
			return Math.ceil(tax * 10 )/10;
		}
	}
	
}
