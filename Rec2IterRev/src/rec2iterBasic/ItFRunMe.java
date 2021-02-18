package rec2iterBasic;

/**
 * Defines a full JAVA method that implements 
 * Listing 1.3, in the paper of reference
 * "Interleaving classical and reversible"
 * by Matos, Polini, Roversi
 * 
 * @author roversi@di.unito.it
 * Released under  Open Software License 3.0 (OSL-3.0) (https://opensource.org/licenses/OSL-3.0)
 */

public class ItFRunMe {
	
  static final int x = 10;

  public static void main(String[] args) {
	
	System.out.println("itF("+x+")="+itF(x));
	
	/* By assumption,
	 * recF is recG applied to non negative arguments only */
    final RecG recF = new RecG(); 
    System.out.println("recF.recG(" + x + ")="+recF.recG(x));
  }
  
  public static int itF(int x) {
    int s = 0, e = 0, g = 0, w = 0, y = 0;
      w = w + x;      
      for (int i = 0; i <= w; i++) {
        if      (x >  0) { g++; }
        else if (x == 0) { e++; }
        else             { s++; }
        x = Pred.pred(x);
      }
 
      for (int i = 0; i <= w; i++) {
        x = Pred.predInv(x);
        if      (x >  0) { g--; y = H.h(x,y); } 
        else if (x == 0) { e--; y = B.b(x);   } 
        else             { s--;               }
      }        
      w = w - x;
      return y;
    }
}