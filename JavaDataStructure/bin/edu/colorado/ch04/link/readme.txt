第四章: 链表
	package edu.colorado.nodes

IntNode
   public void addNodeAfter(int item)   
   {
      link = new IntNode(item, link);
   }
   public void removeNodeAfter( )   
   {
      link = link.link;
   }
	
Node
BooleanNode
ByteNode
CharNode
DoubleNode
FloatNode
LongNode
ShortNode

IntLinkedBag
	使用链表实现的包ADT

DoubleLinkedSeq
	使用链表实现的序列ADT
	序列和包区别:序列存放上次检索的次序
	参考edu.colorado.ch03.array.DoubleArraySeq
	需要自己写代码去实现

