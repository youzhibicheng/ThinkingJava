JAVA编程思想4版，第630页，有导入: 
import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
但是从只有 com.sun ，后面的 mirror 就没有了。 
要确定你的JDK是1.5以上的版本 然后再引入%JAVA_HOME%\lib\tools.jar 包就可以了 
你说的这几个类 在tools.jar里 