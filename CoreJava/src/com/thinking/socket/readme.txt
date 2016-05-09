系统发消息，发到客户终端
还有系统从客户终端定制消息， 不只一个系统，但是消息不能重复

目的：使用单线程重复发送消息给服务器端。
程序清单：
1，ServerTest.java 服务器端
2，SendThread.java 客户端发送线程
3，Client.java 客户端封装类
4，MainClient.java 客户端主程序