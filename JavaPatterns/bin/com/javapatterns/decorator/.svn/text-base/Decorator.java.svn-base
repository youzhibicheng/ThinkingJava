package com.javapatterns.decorator;

public class Decorator implements Component
{
	//最关键的就是这个构造方法
	//有了这个构造方法，装饰模式的对象图就能呈现出链状了
	public Decorator(Component component)
    {
//        super();
        this.component = component;
    }

    public Decorator() {
    }

    public void sampleOperation()
    {
        component.sampleOperation();
    }

    /**
     * @link aggregation 
     */
    private Component component;
}
