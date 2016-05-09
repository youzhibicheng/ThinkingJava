package headfirst.decorator.starbuzz.size1;

public abstract class Beverage {
	String description = "Unknown Beverage";
	CofeSize size ;
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
	
	public CofeSize getSize() {
		return size;
	}

	public void setSize(CofeSize size) {
		this.size = size;
	}
}
