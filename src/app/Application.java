package app;
import matrix.Matrix;
import matrix.MatrixParser;
import shortestpath.Dijkstra;

/**
 * Main
 * @author lev
 *
 */
public class Application {
	public static void main(String[] args) {
		
		long time = System.nanoTime();
		
		MatrixParser mp = new MatrixParser();
		mp.parseMatrix("assets/PPC.dat");
		Matrix m = mp.getMatrix();
		System.out.println(m.toString());
		
		Dijkstra d = new Dijkstra(m);
		d.getPaths(0);
		System.out.println("Execution Time : " + (System.nanoTime() - time)/1E9 );
	}
}
