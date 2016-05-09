Chapter 13. Generic Programming 
	泛型程序设计
	com.thinking.generic

Pair
	泛型类
	
PairTest1
	
PairTest2
	泛型方法
	T extends Comparable & Serializable
	
泛型代码与虚拟机
	虚拟机没有泛型类型对象，所有对象都属于普通类
	所有的类型参数都用他们的边界替换
	桥方法被合成为保持多态的
	为保持类型安全性，必要时插入强制类型转换
	类型擦除
	自动插入强制类型转换
	class DateInterval extends Pair<Date>
	{
	   public void setSecond(Date second){ . . . }
	   . . .
	}
	擦除为
	class DateInterval extends Pair // after erasure
	{
	   public void setSecond(Date second) { . . . }
	   . . .
	}
	有2个方法了
	void setSecond(Date) // defined in DateInterval
	void setSecond(Object) // defined in Pair
	桥接方法 (bridge method)
	public void setSecond(Object second) { setSecond((Date) second); }
	
运行时类型查询只是返回原始类型，与泛型无关

异常
	不能抛出也不能捕获泛型类的对象---泛型类扩展Throwable不合法
	不能在catch子句中使用泛型变量
	在异常声明中可以使用泛型变量
	public static <T extends Throwable> void doWork(T t) throws T // OK
	{
	   TRy
	   {
	      do work
	   }
	   catch (Throwable realCause)
	   {
	      t.initCause(realCause);
	      throw t;
	   }
	}
	
数组
	不能声明参数化类型的数组---擦除---但数组能够记住它的元素类型
	Pair<String>[] table = new Pair<String>(10); // ERROR
	
不能实例化泛型类型
	public Pair() { first = new T(); second = new T(); } // ERROR
不能建立一个泛型数组
	public <T> T[] minMax(T[] a) { T[] mm = new T[2]; . . . } // ERROR
	
不能在静态域或方法中引用泛型变量
	public class Singleton<T>
	{
	   public static T getSingleInstance() // ERROR
	   {
	      if (singleInstance == null) construct new instance of T
	      return singleInstance;
	   }
	   private static T singleInstance; // ERROR
	}
	
In general, there is no relationship between Pair<S> and Pair<T>, no matter how S and T are related

Pair<? extends Employee>
	可以从泛型对象读取
Pair<? super Manager>
	可以向泛型对象写入
Pair<?>
	PairTest3


	