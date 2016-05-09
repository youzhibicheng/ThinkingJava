//: interfaces/interfaceprocessor/FilterProcessor.java
package com.thinking4.interfaces.interfaceprocessor;
import static com.thinking4.util.Print.print;

import com.thinking4.interfaces.filters.*;

class FilterAdapter implements Processor {
  Filter filter;
  public FilterAdapter(Filter filter) {
    this.filter = filter;
  }
  public String name() { return filter.name(); }
  public Waveform process(Object input) {
    return filter.process((Waveform)input);
  }
}	

/*
 * 参考com.thinking4.interfaces.classprocessor.Apply类
 * 当我们无法修改Apply的方法接受
 * public static void process(Filter p, Object s)
 * 但我们却想调用Filter的process方法的时候，我们会想用一个适配器类去适配Filter类
 * */
public class FilterProcessor {
  public static void main(String[] args) {
    Waveform w = new Waveform();
    Apply.process(new FilterAdapter(new LowPass(1.0)), w);
    Apply.process(new FilterAdapter(new HighPass(2.0)), w);
    Apply.process(
      new FilterAdapter(new BandPass(3.0, 4.0)), w);
  }
} /* Output:
Using Processor LowPass
Waveform 0
Using Processor HighPass
Waveform 0
Using Processor BandPass
Waveform 0
*///:~
