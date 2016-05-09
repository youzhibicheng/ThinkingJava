第六章: 栈
edu.colorado.ch06.stack
	先进后出LaterInFirstOut LIFO
	数据插入和删除只在一端(栈顶)进行
	java.util.Stack
	IsBalancedDemonstration
		括号的平衡
	EvaluateDemonstration
		算数表达式求值
		使用了2个栈:
			1. 字符栈
			2. 双精度实数构成的栈
		假设所有输入非负
		假设表达式的格式是正确的
		假设表达式完全带括号,且只使用(和)
	栈ADT的实现
		1. 使用数组	ArrayStack
		2. 使用链表	LinkedStack
		
Stack基本操作
	push()
	pop()
	peek()
	
ArrayStack
	
LinkedStack
   public void push(E item)
   {
      top = new Node<E>(item, top);
   }
   
DerivedStack
	使用LinkedSeq来创造栈


	更复杂的栈应用
	计算和转换表达式是栈典型的应用