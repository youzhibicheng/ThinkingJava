Chapter 2. Collections
	集合
	com.thinking.collections
	
LinkedListTest.java
	链表
	
SetTest.java
	散列集
	
TreeSetTest.java
	树集
	自动排序
	树集的比较方法
		默认实现
		传入Comparator对象
		
PriorityQueueTest.java
	优先级队列
	这个有点奇怪，似乎并没有按照优先级大小来
	
MapTest.java
	映射表
		散列映射表HashMap
		树状映射表TreeMap
		
视图和包装器
	轻量级集合包装器(Lightweight Collection Wrappers)
		List<Card> cardList = Arrays.asList(cardDeck);
	子范围(Subranges)
		List group2 = staff.subList(10, 20);
	不可修改视图(Unmodifiable Views)
		Collections.unmodifiableCollection
		Collections.unmodifiableList
		Collections.unmodifiableSet
		Collections.unmodifiableSortedSet
		Collections.unmodifiableMap
		Collections.unmodifiableSortedMap
	同步视图(Synchronized Views)
		HashMap<String, Employee> hashMap = new HashMap<String, Employee>();
		Map<String, Employee> map = Collections.synchronizedMap(hashMap);
	被检验视图(Checked Views)
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList rawList = strings; // get warning only, not an error, for compatibility with legacy code
		rawList.add(new Date()); // now strings contains a Date object!  这个时候能够添加非String类型
		
		List<String> safeStrings = Collections.checkedList(strings, String.class);//限制添加非String类型
		ArrayList rawList = safeStrings; 
		rawList.add(new Date()); // Checked list throws a ClassCastException 报错
	
批操作(Bulk Operations)
	Set<String> result = new HashSet<String>(a);
	result.retainAll(b);
	
	Map<String, Employee> staffMap = . . .;
	Set<String> terminatedIDs = . . .;
	staffMap.keySet().removeAll(terminatedIDs);
	
集合与数组的转换
	Arrays.asList(array);
	list.toArray();
	
CircularArrayQueueTest.java
	框架的扩展
	
ShuffleTest.java
	排序与混排(Sorting and Shuffling)
	
遗留下来的集合
	Hashtable 
	Properties
	Vector
	Stack
	BitSet
	Enumeration
	
Sieve.java
Sieve2.java
	The "Sieve of Eratosthenes" Benchmark
	利用BitSet筛选素数的方法
	



		
		
	