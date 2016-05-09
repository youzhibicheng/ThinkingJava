Chapter 7. Advanced AWT 
  高级AWT
  com.thinking.awt
  
ShapeTest.java
	绘图操作流程
	
AreaTest.java
	区域Area
	Area支持以下4种操作
		add 
		subtract 
		intersect 
		exclusiveOr 

StrokeTest.java
	比划 Stroke/BasicStroke
	端头样式(end cap styles)
		A butt cap simply ends the stroke at its end point.
		A round cap adds a half-circle to the end of the stroke.
		A square cap adds a half-square to the end of the stroke.
	连接模式(join style )
		A bevel join joins the strokes with a straight line that is perpendicular to the bisector of the angle between the two strokes.
		A round join extends each stroke to have a round cap.
		A miter join extends both strokes by adding a "spike."
	虚线模式
	

PaintTest.java
	着色 Paint/GradientPaint/TexturePaint
	The Color class implements the Paint interface. To fill shapes with a solid color, simply call setPaint with a Color object, such as
		g2.setPaint(Color.red);
	The GradientPaint class varies colors by interpolating between two given color values 
	The TexturePaint class fills an area with repetitions of an image

TransformTest.java
	坐标变换(Coordinate Transformations)
	4种基本变换
		比例缩放Scaling
		旋转Rotation
		平移Translation
		切变Shear
		
ClipTest.java
	剪切Clipping
	在图形上下文设置一个剪切形状
	
CompositeTest.java
	透明与组合 Transparency and Composition
	Transparency is described by an alpha channel
	AlphaComposite
	
RenderQualityTest.java
	绘图提示 Rendering Hints
	RenderingHints
	
ImageIOTest.java
	图像的读取器和写入器 Readers and Writers for Images
	
	File f = . . .;
	BufferedImage image = ImageIO.read(f);
	
	File f = . . .;
	String format = . . .;
	ImageIO.write(image, format, f);
	
	获得图像文件的读取器和写入器
	读取和写入带有多个图像的文件
		ImageIO类的read方法只能够读取单一的图像文件
		应将输入源(多图像文件，比如GIF动画文件)转换成一个ImageInputStream
		InputStream in = . . .;
		ImageInputStream imageIn = ImageIO.createImageInputStream(in);
		reader.setInput(imageIn, true);
		
MandelbrotTest.java
	图像处理
	介绍了对于像素，对于颜色的一些处理方法

ImageProcessingTest.java
	图像过滤
	图形处理都实现了BufferedImageOp接口，建立了图像处理的操作之后，只需调用filter方法，就可以把该图像转换成另一个图像
	BufferedImageOp op = . . .;
	BufferedImage filteredImage
	   = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
	op.filter(image, filteredImage);
	以下5个类实现了BufferedImageOp接口
		AffineTransformOp	
		RescaleOp
		LookupOp
		ColorConvertOp
		ConvolveOp
	
PrintTest.java
	图像打印
	To generate a printout, you take care of these two tasks:
		Supply an object that implements the Printable interface.
		Start a print job.
	
BookTest.java
	打印多页文件
	Book book = new Book();
	Printable coverPage = . . .;
	Printable bodyPages = . . .;
	book.append(coverPage, pageFormat); // append 1 page
	book.append(bodyPages, pageFormat, pageCount);
	printJob.setPageable(book);
	Java平台类并没有提供一个标准的“打印预览”对话框
	
PrintServiceTest.java
	打印服务程序
	DocFlavor flavor = DocFlavor.INPUT_STREAM.GIF;
	PrintService[] services
	   = PrintServiceLookup.lookupPrintServices(flavor, null);

StreamPrintServiceTest
	流打印服务程序
	打印服务程序将打印数据发送给打印机。
	流打印服务程序产生同样的打印数据，但是并不把数据发送给打印机，而是发给流
	DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
	String mimeType = "application/postscript";
	StreamPrintServiceFactory[] factories
	   = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(flavor, mimeType);
	OutputStream out = new FileOutputStream(fileName);
	StreamPrintService service = factories[0].getPrintService(out);

TextTransferTest.java
	Check out the file jre/lib/flavormap.properties on your platform to get an idea about what kinds of objects can be transferred between Java programs and the system clipboard.
	剪贴板
	
ImageTransferTest.java
	构件一个可传递的图像
	Objects that you want to transfer via the clipboard must implement the transferable interface
	The StringSelection class is currently the only public class in the Java standard library that implements the transferable interface

LocalTransferTest.java
	使用本地剪贴板来传递对象引用
	Clipboard clipboard = new Clipboard("local");
	
SerialTransferTest.java
	通过系统剪贴板传递java对象
	Suppose you want to copy and paste objects from one Java application to another. 
	In that case, you cannot use local clipboards. 
	Fortunately, you can place serialized Java objects onto the system clipboard.
	将对象序列化
	
DropTargetTest.java
	3种拖放操作
		Move
		Copy
		Link
	DropTarget / DropTargetListener

DragSourceTest.java
	拖拽源
	DragSource
	
SwingDnDTest.java
	Swing对数据传递的支持
	




