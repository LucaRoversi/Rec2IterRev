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
    int in=7;
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
        System.out.println("1.x="+x+",s="+s+",e="+e+",g="+g+",w="+w);
      }

      for (int i = 0; i < e; i++) {
           predDivX = predDivX + predNotDivX;   
        predNotDivX = predDivX - predNotDivX; 
      }

      for (int j = 0; j < predDivX; j++) { // e > 0
        System.out.println("predDivX");
        for (int i = 0; i <= w; i++) {
          System.out.println("3.x="+x+",s="+s+",e="+e+",g="+g+",w="+w);
          x = Pred.predInv(x);
          if      (x >  0) { g--; y = H.h(x, y); } 
          else if (x == 0) { e--; y = B.b(x);    } 
          else             { s--;                }
        }        
      }

      for (int j = 0; j < predNotDivX; j++) {
        System.out.println("predNotDivX");
        w++;
        for (int i = 0; i <= w; i++) {
            System.out.println("3.x="+x+",s="+s+",e="+e+",g="+g+",w="+w+",z="+z);
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