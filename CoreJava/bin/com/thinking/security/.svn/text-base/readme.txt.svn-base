Chapter 9. Security
	安全
	com.thinking.security
	
Class Loaders类加载器
	虚拟机只加载程序执行时所需要的文件
	Every Java program has at least three class loaders:
		The bootstrap class loader引导类加载器
		The extension class loader扩展类加载器
		The system class loader (also sometimes called the application class loader)系统类加载器
	
	The bootstrap class loader loads the system classes(typically, from the JAR file rt.jar). 
	It is an integral part of the virtual machine and is usually implemented in C.
	There is no ClassLoader object corresponding to the bootstrap class loader. 
	For example: String.class.getClassLoader() returns null.

	The extension class loader loads "standard extensions" from the jre/lib/ext directory
	You can drop JAR files into that directory, and the extension class loader will find the classes in them, even without any class path. 
	
	The system class loader loads the application classes.
	It locates classes in the directories and JAR/ZIP files on the class path
	As set by the CLASSPATH environment variable or the -classpath command-line option
	 
	The extension and system class loaders are implemented in Java. Both are instances of the URLClassLoader class
	
GBC.java
Caesar.java
Calculator.java
ClassLoaderTest.java
Calculator.caesar
CalculatorFrame.caesar
CalculatorPanel$1.caesar
CalculatorPanel$CommandAction.caesar
CalculatorPanel$InsertAction.caesar
CalculatorPanel$InsertAction.caesar



VerifierTest.java
	字节码校验器
	Here are some of the checks that the verifier carries out:
		That variables are initialized before they are used
		That method calls match the types of object references
		That rules for accessing private data and methods are not violated
		That local variable accesses fall within the runtime stack
		That the runtime stack does not overflow
	除了系统类之外，所有类都要被校验，将
	static int fun()
	{
	   int m;
	   int n;
	   m = 1;
	   n = 2;
	   int r = m + n;
	   return r;
	}
	在字节码上修改成
	static int fun()
	{
	   int m = 1;
	   int n;
	   m = 1;
	   m = 2;
	   int r = m + n;
	   return r;
	}
	然后再执行，就出错
	
	
	
Security Managers and Permissions 
	Operations checked by a security manager include the following:
		Whether the current thread can create a new class loader
		Whether the current thread can halt the virtual machine
		Whether a class can access a member of another class
		Whether the current thread can access a local file
		Whether the current thread can open a socket connection to an external host
		Whether a class can start a print job
		Whether a class can access the system clipboard
		Whether a class can access the AWT event queue
		Whether the current thread is trusted to bring up a top-level window
	一旦安装了安全管理器，如果再试图安装第二个安全管理器，哪么只有当原安全管理器同意被替换时，第二个才能成功安装。
	java只能有一个安全管理器
	Local classes had full permissions, and remote classes were confined to the sandbox
	安全策略文件
	set in the file java.security in the jre/lib/security subdirectory of the JDK home directory

	
PermissionTest.java
WordCheckPermission.java
PermissionTest.policy
	java -Djava.security.policy=PermissionTest.policy PermissionTest
	
SecurityManagerTest.java
WordCheckSecurityManager.java
WordCheck.policy
定制安全管理器


JAASTest.java
SimpleCallbackHandler.java
SimpleLoginModule.java
SimplePrincipal.java
SimplePrincipal.java
jaas.config
password.txt
JAASTest.policy

User Authentication
用户认证
