package matrix;

/**
 * If have another format of textfile representing the graph,
 * implement this interface to parse correctly the file and return a Matrix
 * @see matrix.Matrix
 * @author lev
 *
 */
public interface IMatrixParser {
	
	/**
	 * Parse the file
	 * @param matrixPathString the textfile fullpath 
	 * @throws MatrixParserInvalidFormatException
	 */
	public void parseMatrix(String matrixPathString) throws MatrixParserInvalidFormatException;
	
	/**
	 * @return Matrix the parsed matrix
	 */
	public Matrix getMatrix();

}
