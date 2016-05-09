com.javapatterns.isp	 接口隔离原则
Interface Segregation Principal
使用多个专门的接口比使用单一的总接口要好
一个类对另一个类的依赖应当建立在最小的接口上

全文查询搜索引擎的设计
AltaVista是一个搜索引擎公司

反面例子
BadExample

正面例子
搜索器角色
	Searcher
搜索生成器角色
	Indexer
搜索结果集角色
	ResultSet

entitlement