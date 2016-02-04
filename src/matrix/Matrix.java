package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a square Matrix
 * @author lev
 *
 */
public class Matrix {
	private List<List<Integer>> matrix;
	
	/**
	 * Build a Matrix object containing -1
	 * @param length
	 */
	public Matrix(int length) {
		matrix = new ArrayList<List<Integer>>();
		for (int i = 0; i < length; i++) {
			matrix.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				matrix.get(i).add(-1);
			}
		}
	}
	
	/**
	 * @param i the line number
	 * @param j the column number
	 * @return the value stored in (i,j)
	 */
	public int get(int i, int j) {
		return matrix.get(i).get(j);
	}
	
	public int size() {
		return this.matrix.size();
	}
	
	/**
	 * @param i the line number
	 * @param j the column number
	 * @param val the new value of (i,j)
	 */
	public void set(int i, int j, int val) {
		matrix.get(i).set(j, val);
	}
	
	/* 
	 * @return String representing the Matrix
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "";
		for (int j = 0; j < matrix.size(); j++) {
			str += "\n";
			for (int i = 0; i < matrix.size(); i++) {
				str += this.get(j,i) + "\t";
			}
		}
		return str;
		
	}

}
