package headfirst.decorator.starbuzz.size1;

public class Decaf extends Beverage {
	public Decaf() {
		this(CofeSize.GRANDE);
	}

	public Decaf(CofeSize size) {
		description = "Decaf Coffee:" + size;
		setSize(size);
	}
	
	public double cost() {
		switch (size) {
		case TALL:
			return 1.05;
		case GRANDE:
			return 1.15;
		case VENTI:
			return 1.25;
		default:
			return 1.05;
		}
	}
}

