package com.thinking4.holding;
//: holding/PrintingContainers.java
// Containers print themselves automatically.
import java.util.*;
import static com.thinking4.util.Print.*;

public class PrintingContainers {
  static Collection fill(Collection<String> collection) {
    collection.add("rat");
    collection.add("cat");
    collection.add("dog");
    collection.add("dog");
    return collection;
  }
  static Map fill(Map<String,String> map) {
    map.put("rat", "Fuzzy");
    map.put("cat", "Rags");
    map.put("dog", "Bosco");
    map.put("dog", "Spot");
    return map;
  }	
  public static void main(String[] args) {
    print("ArrayList: " + fill(new ArrayList<String>()));
    print("LinkedList: " + fill(new LinkedList<String>()));
    print("HashSet: " + fill(new HashSet<String>()));
    print("TreeSet: " + fill(new TreeSet<String>()));
    print("LinkedHashSet: " + fill(new LinkedHashSet<String>()));
    print("HashMap: " + fill(new HashMap<String,String>()));
    print("TreeMap: " + fill(new TreeMap<String,String>()));
    print("LinkedHashMap: " + fill(new LinkedHashMap<String,String>()));
  }
} /* Output:
[rat, cat, dog, dog]
[rat, cat, dog, dog]
[dog, cat, rat]
[cat, dog, rat]
[rat, cat, dog]
{dog=Spot, cat=Rags, rat=Fuzzy}
{cat=Rags, dog=Spot, rat=Fuzzy}
{rat=Fuzzy, cat=Rags, dog=Spot}
*///:~
