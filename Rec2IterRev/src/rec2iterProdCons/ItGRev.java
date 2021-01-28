package rec2iterProdCons;

public class ItGRev {

  private final Inject inject;
  private final Probe probe;

  ItGRev(Inject inject, Probe probe) {
    this.inject = inject;
    this.probe = probe;
  }

  public void itGRev() throws InterruptedException {
    int s = 0, e = 0, g = 0, w = 0, x = 0;
    int predDivX = 0, predNotDivX = 1; 
      x = inject.swapIn(x);
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
        probe.put(g);
        for (int i = 0; i <= w; i++) {
          x = Pred.predInv(x);
          if      (x >  0) { g--; probe.put(x); } 
          else if (x == 0) { e--; probe.put(x); } 
          else             { s--;               }
        }        
      }

      for (int j = 0; j < predNotDivX; j++) {
        probe.put(g);
        w++;
        for (int i = 0; i <= w; i++) {
          x = Pred.predInv(x);
          if      (x >  0) { g--;
                             x = Pred.pred(x);  
                             probe.put(x); 
                             x = Pred.predInv(x);} 
          else if (x == 0) { e--;                }
          else             { s--;                }
        }
        w--;
      } 
      
      w = w - x;
      x = inject.swapOut(x);
    }
}