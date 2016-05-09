package com.corejava7.annotation;

import java.lang.annotation.*;

//指示注释类型所适用的程序元素的种类
@Target(ElementType.METHOD)
//指示注释类型的注释要保留多久 CLASS/NTIME/SOURCE
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor
{
   String source();
}
