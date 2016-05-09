Chapter 8. JavaBeans Components 
	JaveBean构件
	com.thinking.javabean
	
这章的例子最好用Netbeans来做测试，Eclipse不支持
	
A bean is a reusable software component based on Sun's JavaBeans specification that can be manipulated visually in a builder tool.

To make the JAR file, follow these steps:
	1.  Edit the manifest file.
	2.  Gather all needed class files in a directory.
	3.  Run the jar tool as follows:
		jar cvfm JarFile ManifestFile ClassFiles
		For example,
		jar cvfm ImageViewerBean.jar ImageViewerBean.mf com/thinking/javabean/ImageViewerBean.class

ImageViewerBean.java

Bean Property Types
	1.	Simple Properties
	2.	Indexed Properties
		Type[] getPropertyName()
		void setPropertyName(Type[] x)
		Type getPropertyName(int i)
		void setPropertyName(int i, Type x)
		扩充数组的容量，必须手动创建一个新的数组
	3.	Bound Properties
		Bound properties tell interested listeners that their value has changed
		
		PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
		//That method has three parameters: the name of the property, the old value, and the new value. For example,
		changeSupport.firePropertyChange("fileName", oldValue, newValue);
	4.	Constrained Properties
		A constrained property is constrained by the fact that any listener can "veto" proposed changes, forcing it to revert to the old setting
		eg: the closed property of the JInternalFrame class
		VetoableChangeSupport / VetoableChangeListeners
		
		private VetoableChangeSupport vetoSupport = new VetoableChangeSupport(this);
		public void addVetoableChangeListener(VetoableChangeListener listener)
		{
		   vetoSupport.addVetoableChangeListener(listener);
		}
		public void removeVetoableChangeListener(VetoableChangeListener listener)
		{
		   vetoSupport.removeVetoableChangeListener(listener);
		}

ChartBean.java
ChartBeanBeanInfo.java
	BeanInfo / SimpleBeanInfo
	使用BeanInfo类最常见的原因是为了获取对bean属性的控制权
	这样的话，你只需提供属性名和所属的bean类，就可以为每个属性构建一个PropertyDescriptor，例如:
		PropertyDescriptor descriptor = new PropertyDescriptor("fileName", ImageViewerBean.class);
	然后实现BeanInfo类中的getPropertyDescriptors方法
	
TitlePositionEditor.java
	编写一个属性编辑器
	要实现PropertyEditor接口或PropertyEditorSupport类
	
InverseEditor.java
InverseEditorPanel.java
	To build a GUI-based property editor:
		1.Tell the builder tool that you will paint the value and not use a string.
			public String getAsText() { return null; }
			public boolean isPaintable() { return true; }
		2."Paint" the value the user enters onto the GUI.
			实现paintValue方法
		3.Tell the builder tool that you will be using a GUI-based property editor.
			public boolean supportsCustomEditor() { return true; }
		4.Build the GUI.
			public Component getCustomEditor() { return new InverseEditorPanel(this); }
		5.Write the code to validate what the user tries to enter as the value
			public String getJavaInitializationString() { return "" + getValue(); }
		
DoubleArrayEditor.java
DoubleArrayEditorPanel.java
	设置数组

ChartBean2.java
ChartBean2BeanInfo.java
ChartBean2Customizer.java
	定制器
	Any customizer class you write must implement the Customizer interface. The interface has only three methods:
		The setObject method, which takes a parameter that specifies the bean being customized
		The addPropertyChangeListener and removePropertyChangeListener methods, which manage the collection of listeners that are notified when a property is changed in the customizer
	
JavaBeans Persistence 
	JavaBeans persistence is suitable for long-term storage.
	序列化不适合长期存储
	JavaBeans persistence mechanism saves statements in XML format
	Only those properties that are different from the default are archived
	只有那些与默认值不一样的属性会保存下来，所以存储下的东西比序列化的东西要小
	XMLEncoder / XMLDecoder
	
Employee.java
EnumDelegate.java
PersistenceDelegateTest.java
	JavaBean持久化对象可用于任何数据	Using JavaBeans Persistence for Arbitrary Data
		1.Writing a Persistence Delegate to Construct an Object
			参见Employee的持久化
		2.Constructing an Object from Properties有属性构造对象
		3.Constructing an Object with a Factory Method
		4.Enumerations
		5.Post-Construction Work
		6.Predefined Delegates
		7.Transient Properties
		
EnumDelegate.java
DamageReport.java
DamageReporter.java
	Complete Example for JavaBeans Persistence

	
