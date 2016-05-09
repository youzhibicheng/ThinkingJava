Chapter15:	Generics
	com.thinking4.generics
ArrayMaker.java
	private Class<T> kind;
	(T[])Array.newInstance(kind, size);
CaptureConversion.java
  static <T> void f1(Holder<T> holder) {
    T t = holder.get();
    System.out.println(t.getClass().getSimpleName());
  }
ClassCasting.java
    List<Widget> lw1 = List<Widget>.class.cast(in.readObject());
    List<Widget> lw2 = List.class.cast(in.readObject());
