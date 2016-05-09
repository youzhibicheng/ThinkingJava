package headfirst.decorator.starbuzz.size1;

public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		this(CofeSize.GRANDE);
	}
	
	public DarkRoast(CofeSize size) {
		description = "Dark Roast Coffee:" + size;
		setSize(size);
	}	
 
	public double cost() {
		switch (size) {
		case TALL:
			return .99;
		case GRANDE:
			return 1.09;
		case VENTI:
			return 1.19;
		default:
			return .99;
		}
	}	
	
}

