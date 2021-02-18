package rec2iterProdCons;

/**
 * Defines a full JAVA method that 
 * implements Listing 1.5 in the paper of reference
 * "Interleaving classical and reversible"
 * by Matos, Polini, Roversi
 * 
 * @author roversi@di.unito.it
 * Released under  Open Software License 3.0 (OSL-3.0) (https://opensource.org/licenses/OSL-3.0)
 */

public class ItGCls {

	private final Inject inject;
	private final Probe probe;
	private int out = 0;
	private int in = 0;

	public ItGCls(Inject inject, Probe probe, int x) {
		this.inject = inject;
		this.probe = probe;
		this.in = x;
	}

	public int getOut() {
		return this.out;
	}

	public void itFCls() throws InterruptedException {
		inject.put(in);
		int iterations = probe.get();
		out = B.b(probe.get());
		for (int i = 0; i < iterations; i++) {
			out = H.h(probe.get(), out);
		}
	}
}