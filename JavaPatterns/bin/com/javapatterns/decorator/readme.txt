com.javapatterns.decorator  装饰模式 /包裹模式
装饰模式以对客户端透明的方式扩展对象的功能，是继承关系的一种替代方案

装饰模式的对象图呈链状结构

com.javapatterns.decorator.grepr
	用JAVA语言模拟UNIX上的grep命令
	M：GrepReader
	V: GrepView
	C: Grep
	装饰模式主要体现在 Reader <- FilterReader <- GrepReader 上

com.javapatterns.decorator.greps
	装饰模式主要体现在 FileInputSteam <- DataInputStream <- GrepInputStream 上
	
com.javapatterns.decorator.printinvoice
	打印发票
	发票头部
	发票主部
	发票尾部
	