Chapter 5. Distributed Objects
	分布式对象
	com.thinking.distributed
	
三种技术
	RMI
	CORBA( Common Object Request Broker Architecture )
	SOAP( Simple Object Access Protocol )
	
客户端接口
	interface Product // shared by client and server
	   extends Remote
	{
	   String getDescription() throws RemoteException;
	}
客户端使用
	Product p = . . .; // see below how the client gets a stub reference
	String d = p.getDescription();
	System.out.println(d);
服务器端实现
	public class ProductImpl // server
	   extends UnicastRemoteObject
	   implements Product
	{
	   public ProductImpl(String d)
	      throws RemoteException
	   {
	      descr = d;
	   }
	
	   public String getDescription()
	      throws RemoteException
	   {
	      return "I am a " + descr + ". Buy me!";
	   }
	
	   private String descr;
	}
	1.The ProductImpl constructor is declared to throw a RemoteException because the UnicastRemoteObject might throw that exception if it can't connect to the network service that keeps track of server objects.
	2.RemoteServer(接口)<-UnicastRemoteObject(类)
	
Naming Conventions for RMI Classes	
	No suffix (e.g., Product)				A remote interface
	Impl suffix (e.g., ProductImpl)			A server class implementing that interface
 	Server suffix (e.g., ProductServer)		A server program that creates server objects
 	Client suffix (e.g., ProductClient)		A client program that calls remote methods
 	_Stub suffix (e.g., ProductImpl_Stub)	A stub class that is located on the client (needed prior to JDK 5.0)
 	_Skel suffix (e.g., ProductImpl_Skel)	A skeleton class that is located on the server (needed prior to JDK 1.2)
 
定位服务器对象
	// server
	ProductImpl p1 = new ProductImpl("Blackwell Toaster");
	Context namingContext = new InitialContext();
	namingContext.bind("rmi:toaster", p1);
	// client
	Product p = (Product) namingContext.lookup("rmi://yourserver.com/toaster");
	// rmi example
	rmi://localhost:99/central_warehouse

Product.java / ProductImpl.java / ProductServer.java / ProductClient.java / client.policy
	位于服务器端的文件:
		Product ProductImpl ProductServer
	位于客户端的文件:
		Product ProductClient
	1.Starting the Server
		windows: start->run->type "cmd"->type "start rmiregistry"->type "start java ProductServer"

ShowBindings.java
	列举远程对象
	
Rmi程序测试步骤(实例一):
	去掉包的信息，放到单独的JavaThinking/Rmi/Product/文件夹下面，测试通过
	1.  Compile the source files for the interface, implementation, client, and server classes.
		javac Product*.java
		javac ShowBindings.java
	2.  If you use JDK 1.4 or below, run rmic on the implementation class.
		rmic -v1.2 ProductImpl 
	3.  Start the RMI registry.
		rmiregistry &  or  start rmiregistry
	4.  Start the server.
		java ProductServer & or start java ProductServer
	5.  Run the client.
		java ProductClient
		java ShowBindings
		
远程方法中的参数传递
	When a remote object is passed from the server to the client, the client receives a stub. 
	Using the stub, it can manipulate the server object by invoking remote methods. The object, however, stays on the server. 
	It is also possible to pass and return any objects with a remote method call, not just those that implement the Remote interface.
	当远程对象从服务器传递到客户端时，客户端接收到的是一个存根。使用该存根，可以通过调用远程方法操作服务器对象。该对象始终位于服务器端。
	使用远程方法调用时，可以传递与返回任何对象，不仅是实现了Remote接口的对象
	Whenever an object that is not a remote object needs to be transported from one Java virtual machine to another, 
	The Java virtual machine(第一个Java虚拟机) makes a copy and sends that copy(到第二个Java虚拟机) across the network connection.
	参数传给本地方法->传递对象的引用(对象引用是对象在本地Java虚拟机中的内存地址)
	RMI使用序列化机制通过网络连接发送对象
	
Rmi程序测试步骤(实例二):
	Customer.java Product2.java Warehouse.java WarehouseClient.java client.policy WarehouseClient.properties
	Customer.java Product2.java ProductImpl2.java Warehouse.java WarehouseImpl.java WarehouseServer.java
	
	去掉包的信息，放到单独的JavaThinking/Rmi/Warehouse/All文件夹下面，测试通过
	1.  Compile the source files for the interface, implementation, client, and server classes.
		javac *.java
	2.  If you use JDK 1.4 or below, run rmic on the implementation class.
		rmic -v1.2 ProductImpl 
	3.  Start the RMI registry.
		rmiregistry &  or  start rmiregistry
	4.  Start the server.
		java WarehouseServer & or start java WarehouseServer
	5.  Run the client.
		java WarehouseClient
		
	将Server端和Client的类相互分离存放在JavaThinking/Rmi/Warehouse/Server和JavaThinking/Rmi/Warehouse/Client中，测试通过
	
Remote Objects and the equals and hashCode Methods
	主要是因为Object对象不能抛出RemoteException异常
	you cannot define an equals/hashCode method in a remote interface
	Instead, the equals and hashCode methods on stub objects simply look at the location of the server objects
	
Cloning Remote Objects
	Stubs do not have a clone method
	
Server Object Activation 服务器对象激活
	不需要一次性初始化大量的服务器对象，激活机制允许延迟构造服务器对象
	JavaThinking\Rmi\Activation中有实例
	
Java IDL and CORBA
	CORBA depends on having an Object Request Broker (ORB) available on both client and server.\
	Sun refers to the CORBA support as "Java IDL." 

实现CORBA对象的步骤
	1.  Write the interface that specifies how the object works, using IDL, the interface definition language for defining CORBA interfaces. IDL is a special language to specify interfaces in a language-neutral form(语言中立的形式).
	2.  Using the IDL compiler(s) for the target language(s), generate the needed stub and helper classes.
	3.  Add the implementation code for the server objects, using the language of your choice. (The skeleton created by the IDL compiler is only glue code. You still need to provide the actual implementation code for the server methods.) Compile the implementation code.
	4.  Write a server program that creates and registers the server objects. The most convenient method for registration is to use the CORBA naming service, a service that is similar to the rmiregistry.
	5.  Write a client program that locates the server objects and invokes services on them.
	6.  Start the naming service and the server program on the server, and start the client program on the client. 
These steps are quite similar to the steps that you use to build distributed applications with RMI, but with two important differences:
	You can use any language with a CORBA binding to implement clients and servers.
	You use IDL to specify interfaces.

CORBA例子一:
	JavaThinking\Cobra\Env
	
CORBA例子二(实现CORBA服务器):
	JavaThinking\Cobra\SysProp	


远程方法调用与SOAP
	A web service has two components:
		A server that can be accessed with the Simple Object Access Protocol (SOAP) transport protocol
		A description of the service in the Web Service Description Language (WSDL) format
	实例存放在JavaThinking\Soap\SOAPTest
