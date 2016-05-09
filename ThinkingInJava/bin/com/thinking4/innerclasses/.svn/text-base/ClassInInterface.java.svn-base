package com.thinking4.innerclasses;

//: innerclasses/ClassInInterface.java
// {main: ClassInInterface$Test}

public interface ClassInInterface {
	void howdy();
	//这里还继承了 父接口
	class Test implements ClassInInterface {
	//static class Test implements ClassInInterface {
		public void howdy() {
		//这个方法为什么不能设定成static呢?因为父接口继承的限制
		//public static void howdy() {
			System.out.println("Howdy!");
		}

		public static void main(String[] args) {
			new Test().howdy();
			//Test.howdy();
		}
	}
} /*
 * Output: Howdy!
 */// :~
