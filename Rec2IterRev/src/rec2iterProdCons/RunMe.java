package rec2iterProdCons;

/**
 * Test the Producer/Consumer template that
 * class ItGRevItGCls implements, and compare
 * it with the output of RecG.
 * 
 * @author roversi@di.unito.it
 */

public class RunMe {

  public static void main(String[] args) {
	
    final int in = 3;

    final RecG f = new RecG();
    System.out.println("Final value of recF(" + in + ") = " + f.recF(in));
    
    final ItGRevItGCls itF = new ItGRevItGCls(in);
    try {
		itF.itFRevItFCls();
	} catch (InterruptedException e) { }
    System.out.println("Final value of itF(" + in + ") = " + itF.getOut());
  }
}
