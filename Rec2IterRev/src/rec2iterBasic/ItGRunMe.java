package rec2iterBasic;

/**
 * Defines a full JAVA method that 
 * implements Listing 1.3, named itF,
 * iterative implementation of recF.
 * 
 * @author roversi@di.unito.it
 */

public class ItGRunMe {

  public static void main(String[] args) {
    final RecG f = new RecG();
    int in=3;
    System.out.println("f.recF("+in+")="+f.recG(in));
    System.out.println("ItF("+in+")="+itG(in));
  }
  
  public static int itG(int x) {
    int s = 0, e = 0, g = 0, w = 0, y = 0, z = 0;
    int predDivX = 0, predNotDivX = 1; 
      w = w + x;      
      for (int i = 0; i <= w; i++) {
        if      (x >  0) { g++; } 
        else if (x == 0) { e++; } 
        else             { s++; }
        x = Pred.pred(x);
      }

      for (int i = 0; i < e; i++) {
           predDivX = predDivX + predNotDivX;   
        predNotDivX = predDivX - predNotDivX; 
      }

      for (int j = 0; j < predDivX; j++) { // e > 0
        for (int i = 0; i <= w; i++) {
          x = Pred.predInv(x);
          if      (x >  0) { g--; y = H.h(x, y); } 
          else if (x == 0) { e--; y = B.b(x);    } 
          else             { s--;                }
        }        
      }

      for (int j = 0; j < predNotDivX; j++) {
        w++;
        for (int i = 0; i <= w; i++) {
          x = Pred.predInv(x);
          if      (x >  0) { g--;
                             x = Pred.pred(x);
                             if   (z< 0) {                  } 
                             if   (z==0) { y = B.b(x); z++; } 
                             else        { y = H.h(x, y);   }
                             x = Pred.predInv(x);
                           } 
          else if (x == 0) { e--;                }
          else             { s--;                }
        }
        w--;
      } 
      w = w - x;
      return y;
    }
}