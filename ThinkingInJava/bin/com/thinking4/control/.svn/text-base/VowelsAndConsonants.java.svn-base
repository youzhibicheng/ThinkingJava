package com.thinking4.control;
//: control/VowelsAndConsonants.java
// Demonstrates the switch statement.
import java.util.*;
import static com.thinking4.util.Print.*;
//case 只能是int,byte,short
public class VowelsAndConsonants {
  public static void main(String[] args) {
    Random rand = new Random(47);
    //没遇到break或没到达底部，继续运行
    /*for(int i = 0; i < 100; i++) {
      int c = rand.nextInt(26) + 'a';
      printnb((char)c + ", " + c + ": ");
      switch(c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u': print("vowel");
                  break;
        case 'y':
        case 'w': print("Sometimes a vowel");
                  break;
        default:  print("consonant");
      }
    }*/
    
    //新加的
    for(int i = 0; i < 100; i++) {
        int c = rand.nextInt(26) + 'a';
        printnb((char)c + ", " + c + ": ");
        switch(c) {
          case 'a': print(" a");
          			break;
          case 'e': print(" e");
          			break;
          case 'i': print(" i");
          			break;
          case 'o': print(" o");
          			break;
          case 'u': print(" u");
                    break;
          case 'w': print("Sometimes a vowel");
                    break;
          default:  print("consonant");
        }
      }
  }
} /* Output:
y, 121: Sometimes a vowel
n, 110: consonant
z, 122: consonant
b, 98: consonant
r, 114: consonant
n, 110: consonant
y, 121: Sometimes a vowel
g, 103: consonant
c, 99: consonant
f, 102: consonant
o, 111: vowel
w, 119: Sometimes a vowel
z, 122: consonant
...
*///:~
