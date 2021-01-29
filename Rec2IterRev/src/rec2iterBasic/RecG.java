package rec2iterBasic;

/**
 * Defines recG as in Listing 1.7, for some base function B.b(x) and step
 * function H.h(x, y)
 * 
 * @author roversi@di.unito.it
 */

public class RecG {

	public int recG(int x) {
		if (x <= 0) {
			int r = B.b(x);
			return r;
		} else {
			int r = H.h(x, recG(Pred.pred(x)));
			return r;
		}
	}
}
