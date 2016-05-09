Chapter 12. XML 
	XML文档
	com.thinking.xml
	
The Java library supplies two kinds of XML parsers:
	The Document Object Model (DOM) parser reads an XML document into a tree structure.
	The Simple API for XML (SAX) parser generates events as it reads an XML document.

DOMTreeTest.java
server.xml

验证文档
	DTD
	XML Schema

GridBagTest.java
GridBagPane.java
gridbag.dtd
fontdialog.xml
	DTD
gridbag.xsd
fontdialog-schema.xml
	XML Schema

XPathTest.java
	使用XPath来定位信息
	XPathFactory xpfactory = XPathFactory.newInstance();
	XPath path = xpfactory.newXPath();

使用名字空间
	这个地方比较难于理解
	
SAXTest.java
	使用SAX解析器
	The ContentHandler interface defines several callback methods that the parser executes as it parses the document.
		startElement and endElement are called when a start tag or end tag is encountered.
		characters is called whenever character data are encountered.
		startDocument and endDocument are called once each, at the start and the end of the document.
		这个不是太好理解
	
XMLWriteTest.java
	生成XML文档
	XML Style Sheet Transformations (XSLT) 
	// construct the "do nothing" transformation
	Transformer t = TransformerFactory.newInstance().newTransformer();
	// set output properties to get a DOCTYPE node
	t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, systemIdentifier);
	t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, publicIdentifier);
	// apply the "do nothing" transformation and send the output to a file
	t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(file)));

TransformTest.java
makeprop.xsl
makehtml.xsl
employee.dat
	XSL转换
	
我准备做一个demo,分别用
dom4j
dom
sax
读文件
	节点
	属性
写文件

	