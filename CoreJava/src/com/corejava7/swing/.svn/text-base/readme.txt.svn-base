Chapter 9. User Interface Components with Swing
	Swing用户界面组件

布局管理器
	FlowLayout
	BorderLayout
	GridLayout
	BoxLayout
	GridBagLayout(网格组布局)
	SpringLayout(弹簧布局)

Calculator
	计算器
	BorderLayout和GridLayout组合布局
	
TextTest
	文本输入
	
FormatTest
	格式化的输入域
	整型输入
	失去焦点的行为
		setFocusLostBehavior
	过滤器
	检验器
	
TextAreaTest
	文本区
	
CheckBoxTest
	复选框
	
RadioButtonTest
	单选框
	
BorderTest
	边界
	如果一个窗口中有多组单选按钮，那么就需要用可视化的形式明确地指出那些按钮属于同一组
	BorderFactory
	Border
	
ComboBoxTest
	组合框
	JComboBox
	
SliderTest
	滑块
	JSlider
	
SpinnerTest
	JSpinner组件
	JSpinner
	
MenuTest
	菜单
	JMenuBar
	JMenu
	JMenuItem
	JCheckBoxMenuItem
	JRadioButtonMenuItem
	JPopupMenu
	菜单项中的图标
	复选框和单选按钮菜单项
	快捷键和加速器
		快捷键：快捷键下面有一条横线，是用来从当前打开的菜单中选择一个子菜单或菜单项
		加速器：在不打开菜单的情况下选择菜单项的快捷键
			加速键只能关联到菜单项上，不能关联到菜单上
			加速键并不实际打开菜单，它只是直接激活菜单关联的动作事件
	启用和禁用菜单项
		2种策略
			1.环境发生变化时，就对相关菜单项或动作调用setEnabled
			2.显示菜单之前调用这些项，需要注册监听器
			
ToolBarTest
	工具栏
		工具栏的特殊之处在于可以把它移动到任何地方
		只有工具栏在具有边界布局或其他任何支持North,South,East,West约束布局管理器的容器内才能被拖拽
		JToolBar
	工具提示
	
BoxLayoutTest
	Box容器默认布局
	箱式布局
		水平
		垂直
	默认情况下，箱式布局中各组件之间是没有间距的
	填充件
		支柱(Strut)
		固定区(Area)
		胶水(Glue/Spring)
	Name和Password之间用支柱
	Password和OK/Cancel之间用胶水
	OK和Cancel之间用胶水
	
FontDialog
	GBC帮助类
	网格组布局
	网格组布局是所有布局管理器之首
	网格组布局是没有限制的网格布局
	Netbeans中用可视化进行网格组布局
	
SpringLayoutTest
	弹簧布局管理器
	弹簧具有：最小值，首选值，最大值，实际值
	
CircleLayoutTest
	定制布局管理器
	可以通过自己设计LayoutManager类来实现特殊的布局方式
	
遍历顺序
	从左到右，从上到下
	最早的awt是按照插入容器中的顺序决定的
	
OptionDialogTest
	选项对话框
	showMessageDialog
	showConfirmDialog
	showOptionDialog
	showInputDialog

DataExchangeTest
	数据交换
	目的是获得用户的输入信息
	
FileChooserTest
	文件选择器
	
ColorChooserTest
	颜色选择器
	JColorChooser

第二册	
Chapter 6. Advanced Swing
	高级Swing
	com.thinking.swing

Lists 
	1. The JList Component
		ListTest.java
			wordList.setVisibleRowCount(4); // display 4 items
			//三种显示方式
			JList.VERTICAL(the default)
			JList.VERTICAL_WRAP
			JList.HORIZONTAL_WRAP
			//设置显示方式
			wordList.setLayoutOrientation(JList.VERTICAL);
			wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); \
	   		// select one item at a time
			wordList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	   		// select one item or one range of items
			
		LongListTest.java
			适用于:
				Very long lists
				Lists with changing contents
				Lists that don't contain strings
			解决方法：
				使用MVC模式
				通过ListModel接口对象获取数据
				AbstractListModel
		Inserting and Removing Values
			DefaultListModel可以插入和移除值
		ListRenderingTest.java
			单元格绘制器 接口ListCellRenderer
			class FontCellRenderer extends JPanel implements ListCellRenderer
	2. The JTree Component
		遵循MVC模式
		SimpleTree.java
			TreeNode root = . . .;//树之间建立父子关系
			DefaultTreeModel model = new DefaultTreeModel(root);
			JTree tree = new JTree(model);
		设置树外观
			撤销和显示父子结点之间显示条
				tree.putClientProperty("JTree.lineStyle", "None");
				tree.putClientProperty("JTree.lineStyle", "Angled");
		TreeEditTest.java
			编辑树和树的路径
			TreeNode[] nodes = model.getPathToRoot(newNode);//好奇怪的名字，叫做getPath，得到的却不是path
			TreePath path = new TreePath(nodes);
			tree.scrollPathToVisible(path);
		ClassTree.java
			Node Enumeration结点枚举
			广度优先breadthFirstEnumeration 
			深度优先depthFirstTraversal
			Rendering Nodes绘制结点
				TreeCellRenderer / DefaultTreeCellRenderer
		ClassBrowserTest.java
			Listening to Tree Events监听树事件
			The listener must implement the TreeSelectionListener interface
		ObjectInspectorTest.java
			定制树模型Custom Tree Models
	2. The JTable Component
		PlanetTable.java
			表格直接调用每个对象上的toString方法显示
		InvestmentTable.java
			Table Models表格模型
				继承AbstractTableModel，提供以下3个方法
					public int getRowCount();
					public int getColumnCount();
					public Object getValueAt(int row, int column);
		ResultSetTable.java
			显示数据库记录
		TableSortTest.java
			排序过滤器(A Sort Filter)
			过滤模型将一个对实际表格模型的引用存储起来
			JTable->SortFilterModel->TableModel
			实现需要解决的2个问题:
				1.当用户双击列表头时，必须能获得这个通知
					table.getTableHeader().addMouseListener()
				2.对列表行进行排序
					实现sort方法
		TableCellRenderTest.java
			单元格的绘制与编辑(Cell Rendering and Editing)
			Default Rendering Actions Type
 				Rendered 	As
 				Icon		Image
				Boolean		Checkbox
 				Object		String
			单元格绘制器要实现TableCellRenderer接口的方法getTableCellRendererComponent
		TableSelectionTest.java
			对行和列的操作
				TableColumn
			改变行列大小(Resizing Columns)
			选择行，列，单元格
			
	3. The JEditorPane Component
		JEditorPane displays and edits text in HTML and RTF format
		The subclass JTextPane of JEditorPane can hold styled text with special fonts and text formats, as well as embedded components
		EditorPaneTest.java
		
	4. The JProgressBar Component
		进度条
		ProgressBarTest.java
	
	5. The ProgressMonitor Component
		进度监视器
		ProgressMonitorTest.java
		
	6. The ProgressMonitorInputStream Component
		监视输入流的进度
		ProgressMonitorInputStreamTest.java
		
	7. The JSplitPane Component
		构件组织器->分割面板
		SplitPaneTest.java
	
	8. The JTabbedPane Component
		构件组织器->选项卡面板
		TabbedPaneTest.java
		
	8. The JDesktopPane/JInternalFrame Component
		InternalFrameTest.java
		构件组织器->桌面面板和内部框体/级联与平铺/
 
		
		
	