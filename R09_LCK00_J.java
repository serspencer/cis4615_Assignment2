// Incorrect Code
public class SomeObject {
  //changeValue locks on the class object's monitor
  public static synchronized void changeValue() {
    // ...
  }
}
 
// Untrusted code
synchronized (SomeObject.class) {
  while (true) {                      // In this section an attacker could grab and hold onto the lock
    Thread.sleep(Integer.MAX_VALUE); // Indefinitely delay someObject
  }
}

// Correct Code

public class SomeObject {
  private static final Object lock = new Object();
 
  public static void changeValue() {
    synchronized (lock) { // Locks on the private Object
      // ...
    }
  }
}