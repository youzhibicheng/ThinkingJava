Chapter 1. Multithreading 
	多线程
	com.thinking.multithreading
	
Bounce
	解释什么是线程
	显示了跳动的球，不断移动它，确定它是否从墙壁弹回
	
BounceThread
	能够弹射多个球
	Runnable
	Thread

中断线程
	Interrupting Threads
	interrupt()请求中断一个线程
	isInterrupted()检查线程是否中断
	
线程状态
	New
		new Thread(r)
	Runnable
		t.start()
	Blocked
	Dead

被阻塞线程Blocked
	从Runnable到Blocked
		1.调用sleep进入睡眠状态
		2.在I/O上阻塞
		3.等待锁定
		4.等待触发条件
		5.suspend	
	
	从Blocked到Runnable
		1.睡眠结束
		2.I/O操作完成
		3.锁可用或超时
		4.得到触发通知或超时
		5.resume或超时

死线程Dead
	1.run方法正常退出
	2.stop方法杀死(已过时)
	3.因为一个未捕获的异常终止了run方法而使线程猝死
	isAlive()判断是否存活
		Runnable/Blocked---true
		New/Dead---false
线程属性
	线程优先级
	守护线程
		setDaemon(true)
	线程组
		ThreadGroup
	未捕获异常处理器
		setUncaughtExceptionHandler为任何一个线程安装一个处理器
		setDefaultUncaughtExceptionHandler
		If you don't install a default handler, the default handler is null. 
		However, if you don't install a handler for an individual thread, the handler is the thread's ThreadGroup object.
		
同步
	Synchronization
	
UnsynchBankTest
	没有同步的银行资金转移模拟

SynchBankTest
	利用ReentrantLock进行同步
		Lock bankLock = new ReentrantLock();
		bankLock.lock();
		try
		{
		}
		finally
		{
		   bankLock.unlock();
		}
     条件对象Condition
		Condition sufficientFunds = bankLock.newCondition();
		sufficientFunds.await();
		sufficientFunds.signalAll();

SynchBankTest
	利用synchronized方法实现同步
	
同步块
	synchronized (obj) // this is the syntax for a synchronized block
	{
	   critical section
	}
	
同步格言
	如果你向一个变量写值，而这个变量接下来可能会被另一个线程所读取
	或者你从一个变量读值，而它的值可能是前面由另一个线程写入的，此时你就必须使用同步
	
volatile域
	The volatile keyword offers a lock-free mechanism for synchronizing access to an instance field
	In summary, concurrent access to a field is safe in these three conditions:
		The field is volatile.
		The field is final, and it is accessed after the constructor has completed.
		The field access is protected by a lock.

死锁Deadlocks
	
公平Fairness
	Lock fairLock = new ReentrantLock(true);
	公平锁比普通锁要慢很多
	
锁测试与超时Lock Testing and Timeouts
	myLock.tryLock(100, TimeUnit.MILLISECONDS)
	myCondition.await(100, TimeUnit.MILLISECONDS))
	
读写锁Read/Write Locks
	ReentrantReadWriteLock
	
	//1.Construct a ReentrantReadWriteLock object:
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	//2.Extract read and write locks
	private Lock readLock = rwl.readLock();
	private Lock writeLock = rwl.writeLock();
	
	//3.Use the read lock in all accessors:
	public double getTotalBalance()
	{
	   readLock.lock();
	   try { . . . }
	   finally { readLock.unlock(); }
	}
	
	//4.Use the write lock in all mutators:
	public void transfer(. . .)
	{
	   writeLock.lock();
	   try { . . . }
	   finally { writeLock.unlock(); }
	}

Deprecate stop and suspend Methods 
	
BlockingQueueTest
	阻塞队列
	add/remove/element
		抛异常
	offer/poll/peak
		返回true/false/null
	put/take
		阻塞
	BlockingQueue类型
		LinkedBlockingQueue
			容量无上限
		ArrayBlockingQueue
			构造时需给定容量，可选公平参数
		PriorityBlockingQueue
		DelayQueue
		
线程安全的集合Thread-Safe Collections
	ConcurrentLinkedQueue
	ConcurrentHashMap
	CopyOnWriteArrayList 
	CopyOnWriteArraySet
	
	List synchArrayList = Collections.synchronizedList(new ArrayList());
	Map synchHashMap = Collections.synchronizedMap(new HashMap());
	synchronized (synchHashMap)
	{
	   Iterator iter = synchHashMap.keySet().iterator();
	   while (iter.hasNext()) . . .;
	}


Callable
	与Runnable相似，但有返回值
	public interface Callable<V>
	{
	   V call() throws Exception;
	}
	
Future
	保存异步计算的结果
	当你使用Future对象时，你就可以启动一个计算，把计算结果给某线程，然后就去干你自己的事
	You use a Future object so that you can start a computation, 
	give the result to someone, and forget about it. 
	The owner of the Future object can obtain the result when it is ready.
	
	public interface Future<V>
	{
	   V get() throws . . .;
	   V get(long timeout, TimeUnit unit) throws . . .;
	   void cancel(boolean mayInterrupt);
	   boolean isCancelled();
	   boolean isDone();
	}

FutureTask包装器
	将Callable转换成Future和Runnable,因为FutureTask实现了这2个接口
	Callable<Integer> myComputation = . . .;
	FutureTask<Integer> task = new FutureTask<Integer>(myComputation);
	Thread t = new Thread(task); // it's a Runnable
	t.start();
	. . .
	Integer result = task.get(); // it's a Future

FutureTest
	
ThreadPoolTest
	线程池
	执行器
	ExecutorService pool = Executors.newCachedThreadPool();
	
Scheduled Execution预定执行
	ScheduledExecutorService类

Controlling Groups of Threads控制线程组

Synchronizers同步器
	Barriers
		CyclicBarrier
	Countdown Latches倒计时门栓
		CountDownLatch
	Exchangers
		Exchanger
	Synchronous Queues同步队列
		SynchronousQueue
	Semaphores
	
AlgorithmAnimation信号量
	
线程与swing
	swing不是线程安全的
	
SwingWorkerTest
	加载crsto10.txt
	