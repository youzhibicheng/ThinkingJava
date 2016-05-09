Chapter 5. Inheritance 继承

ArrayGrowTest
	注意goodArrayGrow和arrayPrint中对反射的运用
	java.lang.reflect.Array
	
      Object[] newArray = new Object[newLength];
      System.arraycopy(a, 0, newArray, 0, a.length);
      return newArray;	
	
      Object newArray = Array.newInstance(componentType, newLength);
      System.arraycopy(a, 0, newArray, 0, length);
      return newArray;	

ArrayListTest
	
EnumTest
	枚举类
	Size size = Enum.valueOf(Size.class, input);
	Size[] sizevalues = size.values();
	
EqualsTest
	1.自反性：对于任何非空引用x,x.equals(x)==true
	2.对称性：如果x.equals(y)==true，那么y.equals(x)==true
	3.传递性：如果x.equals(y)==true,y.equals(z)==true，那么x.equals(z)==true
	4.一致性：如果x和y引用的对象没发生变化，那么反复调用x.equals(y)应该返回同样的结果
	5.对于任意非空引用x，x.equals(null)==false
	
	如果重新定义equals方法，则必须重新定义hashCode方法
	
ManagerTest

MethodPointerTest
	反射
	Class.getMethod方法
	Method.invoke方法
	
ObjectAnalyzerTest
	对对象进行剖解分析
	java.lang.reflect.AccessibleObject
		AccessibleObject 类是 Field、Method 和 Constructor 对象的基类。它提供了将反射的对象标记为在使用时取消默认 Java 语言访问控制检查的能力。
		static void setAccessible(AccessibleObject[] array, boolean flag) 
         	使用单一安全性检查（为了提高效率）为一组对象设置 accessible 标志的便捷方法。 
    java.lang.reflect.Modifier
    	Modifier 类提供了 static 方法和常量，对类和成员访问修饰符进行解码。

ReflectionTest
	Class
		 int getModifiers() 
          返回此类或接口以整数编码的 Java 语言修饰符。 
    Modifier
		 static String toString(int mod) 
          返回描述指定修饰符中的访问修饰符标志的字符串。 
    
	
PersonTest
	继承的动态绑定
