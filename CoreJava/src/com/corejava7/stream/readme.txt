Chapter 12. Streams and Files 
	流与文件
	com.thinking.stream
	
InputStream
OutputStream
	字节流

Reader
Writer
	字符流
	Unicode字符单元
	
4个新接口
	Closeable
	Flushable
	Readable
	Appendable
	
ZipTest
	Zip文件流
	java.util.zip.*
	
DataFileTest
	使用分隔符进行输出
	java.util.StringTokenizer
	读取带分隔符的输入
	
StringBuilder
	JDK5.0引入
	比StringBuffer效率高
	StringBuffer可以允许多线程进行增加或移除字符操作
	
RandomFileTest
	随机存取流
	向1个数据文件写入3条记录，然后按照相反方向，从文件中读回
	
ObjectFileTest
	需要序列化
	理解对象序列化文件格式
	
ObjectRefTest
	保存对象引用问题的解决
	理解对象引用的输出格式

修改默认的序列化机制
	标注transient的域不被序列化
	实现Serializable接口
		只需保存和加载自己的数据域，不用关心超类数据及其他类信息
		覆写private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException;
		private void writeObject(ObjectOutputStream out)
		   throws IOException
		{
		   out.defaultWriteObject();
		   out.writeDouble(point.getX());
		   out.writeDouble(point.getY());
		}
		覆写private void writeObject(ObjectOutputStream out)throws IOException;
		private void readObject(ObjectInputStream in)
		   throws IOException
		{
		   in.defaultReadObject();
		   double x = in.readDouble();
		   double y = in.readDouble();
		   point = new Point2D.Double(x, y);
		}
		
	实现Externalizable接口
		将负责整个对象（包含超类数据）的保存和恢复
		覆写public void readExternal(ObjectInputStream in) throws IOException, ClassNotFoundException;
		public void readExternal(ObjectInput s)
		   throws IOException
		{
		   name = s.readUTF();
		   salary = s.readDouble();
		   hireDay = new Date(s.readLong());
		}	
		覆写public void writeExternal(ObjectOutputStream out) throws IOException;
		public void writeExternal(ObjectOutput s)
		   throws IOException
		{
		  s.writeUTF(name);
		  s.writeDouble(salary);
		  s.writeLong(hireDay.getTime());
		}

	enum的序列化机制
		不能使用传统序列化机制
		需要定义特殊方法readResolve
		public class Orientation
		{
		   public static final Orientation HORIZONTAL = new Orientation(1);
		   public static final Orientation VERTICAL  = new Orientation(2);
		   private Orientation(int v) { value = v; }//构造器是私有的
		   private int value;
		}
		protected Object readResolve() throws ObjectStreamException
		{
		   if (value == 1) return Orientation.HORIZONTAL;
		   if (value == 2) return Orientation.VERTICAL;
		   return null; // this shouldn't happen
		}
		
版本Versioning

SerialCloneTest
	使用序列化进行克隆
	Using Serialization for Cloning
	此方法虽然高明，但比显示地构造一个新的对象，然后拷贝或克隆数据域的克隆方法要慢很多
	
FindDirectories
	文件管理
	流类关注的是文件内容，File类关注的是文件在磁盘上的存储
	一个File对象既可以表示文件(isFile)，又可以表示路径(isDirectory)
	
NIOTest
	新的I/O
	内存映射文件
	1.为文件获取通道(channel)
	2.通过调用FileChannel类的map方法可以活得MappedByteBuffer
		3中映射模式
		FileChannel.MapMode.READ_ONLY
		FileChannel.MapMode.READ_WRITE
		FileChannel.MapMode.PRIVATE：结果缓冲区可写，但是任何改变都是私有的，仅仅对该缓冲区有效，并不会写入到文件中
	3.一旦获得了缓冲区，可以用ByteBuffer类和Buffer超类读写数据
	缓冲区数据类型
	文件锁定
		FileLock lock = channel.lock();//一直阻塞知道该锁可用
		FileLock lock(long start, long size, boolean exclusive)//锁住一部分
		FileLock lock = channel.tryLock();//立刻返回，返回该锁或者null
		FileLock tryLock(long start, long size, boolean exclusive)//锁住一部分
		
	