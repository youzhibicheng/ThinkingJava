package headfirst.decorator.starbuzz.size1;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		Beverage beverage = new Decaf();
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());
 
		Beverage beverage2 = new DarkRoast();	beverage2.setSize( CofeSize.VENTI );	
		beverage2 = new Milk(beverage2);
		beverage2 = new Soy(beverage2);
		beverage2 = new Soy(beverage2);	
		
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());
	}
}
