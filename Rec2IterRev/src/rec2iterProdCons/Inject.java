package rec2iterProdCons;

public class Inject {

  private int xInitial = 0;
  private boolean notSet = true;

  private void p(String who, String where, String what) {
//    System.out.println(who + " in "+ where + ": " + what);    
  }
  
  public synchronized int get() throws InterruptedException {
    p(Thread.currentThread().getName(), "Inject.get","enters");
    while (notSet) {
      p(Thread.currentThread().getName(), "Inject.get", "waits for " + notSet);
      wait();
      p(Thread.currentThread().getName(), "Inject.get", "awakes");
    }
    int out = xInitial;
    p(Thread.currentThread().getName(), "Inject.get","exits with " + notSet);
    notify();
    return out;
  }

  public synchronized int swapIn(int in) throws InterruptedException {
    p(Thread.currentThread().getName(), "Inject.swapIn","enters with notSet=" + notSet + ", xInitial="+xInitial+", in="+in);
    while (notSet) {
      p(Thread.currentThread().getName(), "Inject.swapIn", "waits on notSet equal to " + notSet);
      wait();
      p(Thread.currentThread().getName(), "Inject.swapIn", "awakes");
    }
    int out = xInitial;
    xInitial = in;
    p(Thread.currentThread().getName(), "Inject.swapIn","exits with notSet=" + notSet + ", xInitial="+xInitial+", out="+out);
    notify();
    return out;
  }
  
  public synchronized int swapOut(int in) throws InterruptedException {
    p(Thread.currentThread().getName(), "Inject.swapOut","enters with notSet=" + notSet + ", xInitial="+xInitial+", in="+in);
//    while (!notSet) {
//      p(Thread.currentThread().getName(), "Inject.swapOut", "waits on notSet equal to " + notSet);
//      wait();
//      p(Thread.currentThread().getName(), "Inject.swapOut", "awakes");
//    }
    int out = xInitial;
    xInitial = in;
    notSet = !notSet;
    p(Thread.currentThread().getName(), "Inject.swapOut","exits with notSet=" + notSet + ", xInitial="+xInitial+", out="+out);
    notify();
    return out;
  }
  
  public synchronized void put(int in) throws InterruptedException {
    p(Thread.currentThread().getName(), "Inject.put","enters with notSet=" + notSet + ", in="+in);
    while (!notSet) {
      p(Thread.currentThread().getName(), "Inject.put", "waits on notSet equal to " + notSet);
      wait();
      p(Thread.currentThread().getName(), "Inject.put", "awakes");
    }
    xInitial = in;
    notSet = !notSet;
    p(Thread.currentThread().getName(), "Inject.put","exits with notSet=" + notSet + ", xInitial="+xInitial);
    notify();
  }
}