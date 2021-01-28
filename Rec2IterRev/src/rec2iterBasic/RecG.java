package rec2iterBasic;

/**
 * Defines recG as in Listing 1.7, 
 * for some base function B.b(x)
 * and step function H.h(x, y)
 * 
 * @author roversi@di.unito.it
 */

public class RecG {
  
  public int recG(int x) {
    if (x <= 0) {
      int r = B.b(x);
//      System.out.println("recG B.b(" + x + ")="+r);
      return r;
    } else {
      int y = recG(Pred.pred(x));
      int r = H.h(x, y);
//      int r = H.h(Pred.pred(x), y);
//      System.out.println("recG H.h(" + x + ","+ y + ")=" + r);
      return r;
    }
  }
}
