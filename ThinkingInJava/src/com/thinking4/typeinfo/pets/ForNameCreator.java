//: typeinfo/pets/ForNameCreator.java
package com.thinking4.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.thinking4.typeinfo.pets.Mutt",
    "com.thinking4.typeinfo.pets.Pug",
    "com.thinking4.typeinfo.pets.EgyptianMau",
    "com.thinking4.typeinfo.pets.Manx",
    "com.thinking4.typeinfo.pets.Cymric",
    "com.thinking4.typeinfo.pets.Rat",
    "com.thinking4.typeinfo.pets.Mouse",
    "com.thinking4.typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
