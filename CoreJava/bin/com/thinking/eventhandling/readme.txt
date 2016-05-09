图形界面的事件处理

ButtonTest
	处理按钮点击事件
	
PlafTest
	改变观感
	UIManager
	UIManager.LookAndFeelInfo
	UIManager.setLookAndFeel(plafName);
	SwingUtilities.updateComponentTreeUI(PlafPanel.this);
	
awt事件继承层次
awt语义事件:表达用户动作的事件
	ActionEvent：对应鼠标单击，菜单选择，选择列表项，在文本中键入enter
	AdjustmentEvent：用户调节滚动条
	ItemEvent：用户从复选框或列表框选择一项
awt低级事件:形成那些事件的事件
	所有低级事件都继承ComponentEvent
	KeyEvent
	MouseEvent
	MouseWheelEvent
	FocusEvent
	WindowEvent
	
Sketch
	键盘事件
	Java明确区分字符和虚拟键码
	keyPressed		获取按下键盘的事件
	keyReleased		获取松开键盘的事件
	keyTyped		报告用户敲击键盘所产生的字符
	
MouseTest
	鼠标事件
	当用户按下鼠标时候，将会调用3个监听器方法
		1.第一次按下时候调用mousePressed
		2.鼠标释放时调用mouseReleased
		3.最后调用mouseClicked
	
ActionTest
	动作
	几个事件源向同一监听器报告
	
MulticastTest
	多点传送
	几个监听器向同一个事件源报告
	Close All按钮有多个监听器
		
EventSourceTest
	实现事件源
	Frame对形状改变做出响应
	事件：形状改变
	响应：改变Title的显示值
	定义事件源3要素
		1.事件类型
			PropertyChangeEvent
		2.事件监听接口
			PropertyChangeListener
		3.增加或删除监听器的方法
			addPropertyChangeListener(PropertyChangeListener)
			removePropertyChangeListener(PropertyChangeListener)
	这个例子比较有难度
	