package com.thinking4.innerclasses;

import static com.thinking4.util.Print.print;

interface IncrementableAdapter {
	void increment();
}

// Very simple to just implement the interface:
class Callee1Adapter implements IncrementableAdapter {
	private int i = 0;

	public void increment() {
		i++;
		print(i);
	}
}

class MyIncrementAdapter {
	public void increment() {
		print("Other operation");
	}

	static void f(MyIncrement mi) {
		mi.increment();
	}
}

// If your class must implement increment() in
// some other way, you must use an inner class:
class Callee2Adapter extends MyIncrementAdapter {
	private int i = 0;

	public void increment() {
		super.increment();
		i++;
		print(i);
	}
}

/*
 * 用来将MyIncrementAdapter适配成IncrementableAdapter
 */
class Callee3Adapter implements IncrementableAdapter {
	MyIncrementAdapter adapter;

	public Callee3Adapter(MyIncrementAdapter ad) {
		adapter = ad;
	}

	@Override
	public void increment() {
		adapter.increment();
	}

}

/*
 * 这里的目的是Caller类只能应用于Incrementable接口 但却想调用MyIncrement接口的类 既可以用闭包实现，应该也能用适配器模式实现
 */
public class CallbacksAdapter {
	public static void main(String[] args) {
		IncrementableAdapter i1 = new Callee1Adapter();
		IncrementableAdapter i2 = new Callee3Adapter( new Callee2Adapter() );
		i1.increment();
		i2.increment();
	}
}
