Chapter 13. Annotations 
	注释
	com.thinking.annotation
	
ButtonTest.java
ActionListenerFor.java
ActionListenerInstaller.java
	annotation declaration
		modifiers @interface AnnotationName
		{
		   element declaration1
		   element declaration2
		   . . .
		}
	element declaration
		type elementName();
		type elementName() default value;
	Defaults are not stored with the annotation; instead, they are dynamically computed.
	marker annotation
		@BugReport 没有值或者全部是缺省值
		=@BugReport(assignedTo="[none]", severity=0)
	value annotation
		public @interface ActionListenerFor
		{
		   String value();
		}
		@ActionListenerFor("yellowButton")
	All annotation interfaces implicitly extend the interface java.lang.annotation.Annotation. 
	That interface is a regular interface, not an annotation interface. 
	You cannot extend annotation interfaces. In other words
	all annotation interfaces directly extend java.lang.annotation.Annotation
	
	The type of an annotation element is one of the following:
		A primitive type (int, short, long, byte, char, double, float, or boolean)
		String
		Class (with an optional type parameter such as Class<? extends MyClass>)
		An enum type
		An annotation type
		An array of the preceding types
	An annotation element can never be set to null. Not even a default of null is permissible
	Annotation可以嵌套
	
	The Standard Annotations Annotation Interface
		Deprecated
		SuppressWarnings
		Override
		Target
		Retention
		Documented
		Inherited
	
The apt Tool for Source-Level Annotation Processing
用户源码级Annotation处理的apt工具
Property.java
ChartBean.java
BeanInfoAnnotationFactory.java
DoubleArrayEditor.java
DoubleArrayEditorPanel.java
InverseEditor.java
InverseEditorPanel.java
TitlePositionEditor.java
GBC.java
	要使用com.sun.mirror.apt等包，需要引入java的tools.jar文件	
	javac -classpath .:%JAVA_HOME%/lib/tools.jar BeanInfoAnnotationFactory.java
	javac *.java
	apt -factory BeanInfoAnnotationFactory ChartBean.java
	
Bytecode Engineering
字节码工程
EntryLogger.java
EntryLoggingAgent.java
Item.java
LogEntry.java
SetTest.java
EntryLoggingAgent.mf
	


