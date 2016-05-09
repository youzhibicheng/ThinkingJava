com.javapatterns.bridge	 桥梁模式

了解
	开闭原则
		对扩展开放，对修改关闭
	合成聚合复用原则
		要尽量使用组合聚合，要尽量少使用继承
	
将抽象化与实现化脱藕，使得两者可以独立的变化

脱藕是指在一个软件系统的抽象化和实现化之间使用组合/聚合关系而不是继承关系，
从而使两者可以独立的地变化

com.javapatterns.bridge.peer
Java语言中的Peer架构，不同的操作系统下有不同的风格
在每个Java构件和它的Peer构件之间有一个Peer接口

驱动器和JDBC驱动器
	ExcelReader

空客Airbus
波音Boeing
麦道MD
都生产 
 载客飞机PassengerPlane 
 载货飞机CargoPlane
com.javapatterns.bridge.airplanes
	Airplane
	不好的设计
com.javapatterns.bridge.airplanes2
	AirplaneMaker
	Airplane
