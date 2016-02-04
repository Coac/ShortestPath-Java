package matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Parse a textfile to return a Matrix
 * @author lev
 *
 */
public class MatrixParser implements IMatrixParser{
	private Matrix matrix;
	private int length;
	
	public MatrixParser() {
		
	}
	
	@Override
	public Matrix getMatrix() {
		return this.matrix;
	}

	@Override
	public void parseMatrix(String matrixPathString) throws MatrixParserInvalidFormatException {
		File file = new File(matrixPathString);
		
		try {
			Scanner scan = new Scanner(file);
			if(!scan.hasNextInt()) {
				throw new MatrixParserInvalidFormatException();
			}
			this.length = scan.nextInt();
			
			int i = 0;
			int j = 0;
			this.matrix = new Matrix(length);
			boolean first = true;
			while(true) {
				if(!scan.hasNextInt()) {
					throw new MatrixParserInvalidFormatException();
				}
				
				
				if(j % length == 0 && !first) i++;
				
				
				matrix.set(i , j % length, scan.nextInt());
				j++;
				first = false;
				
				if(i == length -1 && j == length * length)
					break;
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
