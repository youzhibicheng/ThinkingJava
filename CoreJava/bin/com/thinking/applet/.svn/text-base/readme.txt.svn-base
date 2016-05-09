Chapter 10. Deploying Applets and Applications
	部署applet和应用程序
	com.thinking.applet
	
NotHelloWorldApplet
NotHelloWorldApplet.html
	一个简单的applet
	但有包的applet的引入问题一直得不到解决
	
CalculatorPanel
CalculatorApplet
CalculatorApplet.html
	将应用程序转换为applet
	
	
applet声明周期
	init
		只调用一次
	start
		可调用多次
	stop
		可调用多次
	destory
		浏览器正常关闭时才会调用
	
CalculatorPanel	
PopupCalculatorApplet
PopupCalculatorApplet.html
	applet的弹出式窗口
	
用于编码的applet属性
	codebase
	archive
	object
		指定包含序列化applet对象的文件的名字
		使用这个属性时，init方法不调用，但start方法调用
		可以恢复到上次浏览器关闭时的状态
		
Chart
Chart.html
	使用参数向applet传递信息
	只能在applet中的init方法中调用getParameter方法，而不是在构造器中调用
	当applet构造器执行时，参数还没准备好
	name

applet上下文
	getAppletContext()
	一个网页包含多个applet，如果网页中包含的多个applet都来自同一个codebase，他们之间可以通信
	一个applet不能与其他网页上的applet通信
	
Bookmark.java
Bookmark.html
Left.html
Right.html
	书签applet
	
AppletFrame
CalculatorApplet.java
CalculatorAppletApplication.java
CalculatorAppletApplication.html
	既是applet，又是应用程序
	AppletStub
	AppletContext
	
jar文件
	archive="*.jar"
清单文件
	META_INF/MANIFEST.MF
	
ResourceTest
	资源
	
Java Web Start
	1.打包到一个或多个jar文件中
	2.创建JNLP格式描述符
	3.将这些文件放置到web服务器上
	4.确保web服务器对于具有.jnlp后缀的文件报告一个application/x-java-jnlp-file的mime类型描述
Java Web Start发布计算器程序
	1.编译Calculator.java
	2.准备Calculator.ml
		Main-Class:Calculator
	3.使用下列命令创建jar文件
		jar cvmf Calculator.jar Calculator.mf *.class
	4.准备启动文件Calculator.jnlp
	5.%TOMCAT_HOME%/webapps/calculator/WEB-INF/web.xml
	  %TOMCAT_HOME%/webapps/calculator/Calculator.jar
	  %TOMCAT_HOME%/webapps/calculator/Calculator.jnlp
	6.启动Tomcat, http://localhost:8080/calculator/Calculator.jnlp
	7.再次访问jnlp文件，应用程序从缓存中取出

WebStartCalculator.java
WebStartCalculator.jnlp
WebStartCalculator.mf
	JNLP API
	要编译使用了JNLP API的程序，必须在类路径中包含jre/lib/javaws.jar
	FileOpenService
	FileSaveService
	PersistenceService
		允许应用程序保存少量的配置信息
		并且可以在应用程序下次运行时取回
	
CustomWorld
	应用程序配置的存储
	Properties
	
SystemInfo
	系统信息
	
PreferencesTest
	Preferences API

