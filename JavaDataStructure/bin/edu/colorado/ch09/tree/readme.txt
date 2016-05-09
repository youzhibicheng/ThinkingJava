第九章: 树
edu.colorado.ch09.tree
非线性结构
结点/根节点/叶子结点/左孩子/右孩子/双亲/兄弟/祖先/后代/子树/结点的左子树和右子树/结点的深度/树的深度
满二叉树: 每个叶子结点深度都相同, 每个非叶子结点都有2个孩子
完全二叉树: 满二叉树,从左至右添加新叶子结点,所有新叶子结点具有相同的深度,并且总是先添加最左边的一个结点
决策树: yes/no 二叉树
完全二叉树的数组表示
使用结点类表示二叉树
BTNode
	public E getLeftmostData()	从最左结点取得数据,从根结点开始只沿左连接可以得到最左结点
	public E getRightmostData()
	public void inorderPrint()	中序遍历
	public void preorderPrint()	前序遍历
	public void postorderPrint()后序遍历
	public void print(int depth)
	//下面这个方法比较抽象,要仔细理解,顺便进一步理解递归
   public BTNode<E> removeLeftmost( )
   {
      if (left == null)
         return right;
      else
      {
         left = left.removeLeftmost( );
         return this;
      }
   }
递归算法存在的两个必要条件:
	1. 必须有递归的终止条件
	2. 过程的描述中包含它本身
递归算法解题通常显得很简洁，但递归算法解题的运行效率较低
	
猜动物
AnimalGuess

二叉查找树
IntTreeBag
比较 edu.colorado.ch03.array.IntArrayBag 和 edu.colorado.ch04.link.IntLinkedBag
需要自己实现
使用二叉树来实现包