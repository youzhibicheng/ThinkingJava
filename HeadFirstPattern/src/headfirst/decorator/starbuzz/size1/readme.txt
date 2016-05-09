如果加上  按照 大中小杯再收费呢？
注意，这里是饮料都按大小杯收费还是仅仅是包含调料

第一种：饮料有大小杯，调料只能根据饮料的大小杯来决定

这个是加了大中小杯之后的第一个解决方案(由James ZOU提供)

1. Beverage中加入变量size和get/set方法
2. 被装饰类加上构造方法
	public DarkRoast(CofeSize size) {
		description = "Dark Roast Coffee:" + size;
		setSize(size);
	}	
3. 装饰类的构造方法改变
	public Milk(Beverage beverage) {
		this.beverage = beverage;
		this.setSize( beverage.getSize() );//注意，这里改变了
	}
4. 根据容量决定价格，改写cost方法

	习题答案里提到了更好的解决方案，不创建CofeSize的枚举型，而是将其写到Beverage类中
	static final int TALL = 1 ;
	static final int GRANDE = 2 ;
	static final int VENTI = 3 ;
