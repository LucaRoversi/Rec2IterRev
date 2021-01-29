package rec2iterProdCons;

public class RecG {

	public int recF(int x) {
		if (x <= 0) {
			int r = B.b(x);
			return r;
		} else {
			int r = H.h(x, recF(Pred.pred(x)));
			return r;
		}
	}
}
