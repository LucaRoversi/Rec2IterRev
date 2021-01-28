package rec2iterProdCons;

public class Probe {

  private int x = 0;
  private boolean xAvailable = false;

  private void p(String who, String where, String what) {
//    System.out.println(who + " in " + where + ": " + what);
  }

  public synchronized int get() throws InterruptedException {
    p(Thread.currentThread().getName(), "Probe.get","enters");
    while (!xAvailable) {
      p(Thread.currentThread().getName(), "Probe.get","waits");
      wait(); // producer has not produced yet
      p(Thread.currentThread().getName(), "Probe.get", "awakes");
    }
    int out = x;
    xAvailable = !xAvailable;
    notify();
    p(Thread.currentThread().getName(), "Probe.get","exits");
    return out;
  }

  public synchronized void put(int in) throws InterruptedException {
    p(Thread.currentThread().getName(), "Probe.put","enters");
    while (xAvailable) {
      p(Thread.currentThread().getName(), "Probe.put","waits");
      wait(); // consumer has not consumed yet
      p(Thread.currentThread().getName(), "Probe.put", "awakes");
    }
    x = in;
    xAvailable = !xAvailable;
    p(Thread.currentThread().getName(), "Probe.put","exits");
    notify();
  }
}