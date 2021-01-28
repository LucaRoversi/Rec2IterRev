package rec2iterProdCons;

/**
 * Implements the Producer/Consumer template.
 * It makes instances of:
 * - the producer itGRev, 
 * - the consumer itGCls,
 * - communication channels. 
 * It implements all the details relative to Section.
 * 
 * @author roversi@di.unito.it
 */

public class ItGRevItGCls {
	
  private int in = 0;
  private int out = 0;
	
  public ItGRevItGCls (int x) {
	  this.in = x;
  }

  public int getOut() {
	  return out;
  }
  
  public void itFRevItFCls() throws InterruptedException {
    
    final Inject injectChannel = new Inject();
    final Probe probeChannel = new Probe();
    final ItGCls itGCls = new ItGCls(injectChannel, probeChannel, in);
    final ItGRev itGRev = new ItGRev(injectChannel, probeChannel);

    Thread consumerThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          itGCls.itFCls();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "Consumer thread");

    Thread producerThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          itGRev.itGRev();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "Producer thread");

    producerThread.start();
    consumerThread.start();
    producerThread.join();
    out = itGCls.getOut();
  }
}
