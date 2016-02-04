package shortestpath;

import matrix.Matrix;

/**
 * Implementation of Shortest path algorithm should extend this class
 * @author lev
 *
 */
public abstract class AbstractShortestPath {
	
	/**
	 * The graph adjacency matrix
	 */
	protected Matrix matrix;
	
	/**
	 * Generic Constructor to assign an adjacency matrix to the class
	 * @param m the matrix
	 */
	public AbstractShortestPath(Matrix m) {
		this.matrix = m;
	}
	
	/**
	 * @param start the start vertex
	 * @return String All the shortest paths for each vertices
	 */
	public abstract String getPaths(int start);

}
