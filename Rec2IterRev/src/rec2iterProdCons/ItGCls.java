package rec2iterProdCons;

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