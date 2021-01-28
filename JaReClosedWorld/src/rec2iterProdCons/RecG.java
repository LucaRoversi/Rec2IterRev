package rec2iterProdCons;

public class RecG {
  
  public int recF(int x) {
    if (x <= 0) {
      int r = B.b(x);
//      System.out.println("recF B.b(" + x + ")="+r);
      return r;
    }
      
    else {
      int y = recF(Pred.pred(x));
      int r = H.h(x, y);
//      System.out.println("recF H.h(" + x + ","+ y + ")=" + r);
      return r;
    }
  }
}
