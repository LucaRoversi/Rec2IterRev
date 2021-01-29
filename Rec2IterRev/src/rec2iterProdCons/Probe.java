package rec2iterProdCons;

public class Probe {

  private int x = 0;
  private boolean xAvailable = false;

  public synchronized int get() throws InterruptedException {
    while (!xAvailable) { wait(); } // producer has not produced yet
    int out = x;
    xAvailable = !xAvailable;
    notify();
    return out;
  }

  public synchronized void put(int in) throws InterruptedException {
    while (xAvailable) { wait(); } // consumer has not consumed yet
    x = in;
    xAvailable = !xAvailable;
    notify();
  }
}