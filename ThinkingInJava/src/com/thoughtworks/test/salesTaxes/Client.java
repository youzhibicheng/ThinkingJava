package com.thoughtworks.test.salesTaxes;

import com.thoughtworks.test.salesTaxes.cart.ShoppingCart;
import com.thoughtworks.test.salesTaxes.product.BasicProductDecorator;
import com.thoughtworks.test.salesTaxes.product.IProduct;
import com.thoughtworks.test.salesTaxes.product.ImportProductDecorator;
import com.thoughtworks.test.salesTaxes.product.Product;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ShoppingCart pg1 = new ShoppingCart();
		IProduct pa1 = new Product("book",12.49);
		IProduct pa2 = new BasicProductDecorator(
				new Product("music CD",14.99)
		);
		IProduct pa3 = new Product("chocolate bar",0.85);
		pg1.add(pa1);
		pg1.add(pa2);
		pg1.add(pa3);
		
		ShoppingCart pg2 = new ShoppingCart();
		IProduct pb1 = new ImportProductDecorator(
				new Product("box of chocolates",10.00)
		);
		IProduct pb2 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",47.50)
				)
		);
		pg2.add(pb1);
		pg2.add(pb2);
		
		ShoppingCart pg3 = new ShoppingCart();
		IProduct pc1 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",27.99)
				)
		);
		IProduct pc2 = new BasicProductDecorator(
				new Product("bottle of perfume",18.99)
		);
		IProduct pc3 = new Product("packet of headache pills",9.75);
		IProduct pc4 = new ImportProductDecorator(
				new Product("box of chocolatese",11.25)
		);
		pg3.add(pc1);
//		pg3.add(pc1);
		pg3.add(pc2);
		pg3.add(pc3);
		pg3.add(pc4);
		
		System.out.println("INPUT:");
		System.out.println(pg1);
		System.out.println(pg2);
		System.out.println(pg3);
		
		pg1.computeTax();
		pg2.computeTax();
		pg3.computeTax();
		
		System.out.println("OUTPUT:");
		System.out.println(pg1);
		System.out.println(pg2);
		System.out.println(pg3);		
	}

}
