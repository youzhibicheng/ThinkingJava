package headfirst.decorator.starbuzz.size1;

public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
		this.setSize( beverage.getSize() );
	}

	public String getDescription() {
		return beverage.getDescription() + " , Milk:" + size;
	}

	public double cost() {
		if( beverage.getSize() == CofeSize.TALL ){
			return .10 + beverage.cost();
		} else if( beverage.getSize() == CofeSize.GRANDE ){
			return .15 + beverage.cost();
		} else {
			return .20 + beverage.cost();
		}		
	}
}
