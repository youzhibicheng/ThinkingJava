package com.thinking4.io;

import java.io.File;

import org.eclipse.swt.internal.Platform;
/*
 * 主要是为了测试Java有了包之后，其在文件中的路径信息
 * */
public class FilePathTest {
    public static void main(String[] args) throws Exception {
    	String packagePath = FilePathTest.class.getPackage().getName().replace('.', '/');
    	System.out.println(packagePath);
    	//file:/D:/Workspace/JavaThinking/JavaThinking/bin/
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        ///D:/Workspace/JavaThinking/JavaThinking/bin/
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        //null
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("/"));
        //file:/D:/Workspace/JavaThinking/JavaThinking/bin/
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("./"));
        //null
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("../"));
        //null
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(".."));
        //file:/D:/Workspace/JavaThinking/JavaThinking/bin/
        System.out.println(ClassLoader.getSystemResource("")); 
        //null
        System.out.println(ClassLoader.getSystemResource("/"));
        //null
        System.out.println(ClassLoader.getSystemResource("../"));
        //file:/D:/Workspace/JavaThinking/JavaThinking/bin/
        System.out.println(FilePathTest.class.getClassLoader().getResource(""));
        //file:/D:/Workspace/JavaThinking/JavaThinking/bin/com/thinking4/io/
        System.out.println(FilePathTest.class.getResource(""));  
        //file:/D:/Workspace/JavaThinking/JavaThinking/bin/
        System.out.println(FilePathTest.class.getResource("/"));
        //D:\
        System.out.println(new File("/").getAbsolutePath());
        //D:\Workspace\JavaThinking\JavaThinking
        System.out.println(new File("").getAbsolutePath());
        //D:\Workspace\JavaThinking\JavaThinking
        System.out.println(System.getProperty("user.dir")); 
        
//        java.net.URL url = FilePathTest.class.getResource(""); // ClassName为这个调用类的名字 
//        String pathPrefix = url.getPath();//.substring(); // 字符串截取 
//        String url = FilePathTest.class.getClassLoader().getResource(".").getPath();
//        url = java.net.URLDecoder.decode(url,"utf-8");
//        System.out.println(url);
    }  
}
