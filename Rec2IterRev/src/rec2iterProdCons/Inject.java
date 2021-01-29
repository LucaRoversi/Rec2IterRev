package rec2iterProdCons;

public class Inject {

	private int xInitial = 0;
	private boolean notSet = true;

	public synchronized int get() throws InterruptedException {
		while (notSet) {
			wait();
		}
		int out = xInitial;
		notify();
		return out;
	}

	public synchronized int swapIn(int in) throws InterruptedException {
		while (notSet) {
			wait();
		}
		int out = xInitial;
		xInitial = in;
		notify();
		return out;
	}

	public synchronized int swapOut(int in) throws InterruptedException {
		int out = xInitial;
		xInitial = in;
		notSet = !notSet;
		notify();
		return out;
	}

	public synchronized void put(int in) throws InterruptedException {
		while (!notSet) {
			wait();
		}
		xInitial = in;
		notSet = !notSet;
		notify();
	}
}