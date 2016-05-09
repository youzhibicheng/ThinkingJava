Chapter 11. Exceptions and Debugging 
	异常与调试
	com.thinking.exception
	
异常层次结构
	Throwable
		Error
		Exception
			IOException
			RuntimeException
			
StackTraceTest
	堆栈跟踪元素分析
	
ExceptTest
	java错误与异常处理
	
ExceptionalTest
	
LoggingImageViewer
	日志

断言
	assert 条件;
		如果条件为false，抛出一个AssertionError异常
	assert 条件:表达式;
		如果条件为false，抛出一个传入参数为表达式的AssertionError异常
	默认禁用
	启用
		-enableassertion
		-ea
	禁用
		-disableassertion
		-da
	启用和禁用断言时不必重新编译程序
	断言失败是致命的，不可恢复的错误
	断言检查只用于开发和测试阶段

调试
	以-verbose标志运行虚拟机观察类的加载过程
	
ConsoleWindow
ConsoleWindowTest
	使用控制台窗口
	
EventTracer
EventTracerTest
	跟踪awt事件
	
RobotTest
ButtonFrame
ButtonPanel
	Robot类将敲击键盘和点击鼠标的事件发送给awt程序，并能够对用户界面进行自动检测

	
	
	