# ShortestPath-Java
A Java implementation of shortest path algorithm.
Dijkstra is an example of implementation

## Package matrix
This package contains all the class related to the matrix implementation.
IMatrixParser parse a file, String or a stream to return a Matrix.

## Package shortestpath
If you want to implement other shortest path algortithm, you can extend it with AbstractShortestPath.
Thus the class will be connected to the project.
Dijkstra algorithm is working

## Example
With the actual MatrixParser and Dijkstra
Input : 
```
10									
999	1	9	999	999	999	999	999	999	999
999	999	999	5	999	1	999	999	999	999
999	999	999	999	999	999	2	999	999	999
999	999	999	999	3	999	999	999	999	999
999	999	999	999	999	999	999	4	999	999
999	999	1	6	8	999	4	999	999	999
999	999	999	999	999	999	999	1	999	999
999	999	999	999	1	999	999	999	2	5
999	999	999	999	999	999	999	999	999	1
999	999	999	999	999	999	999	999	999	999
```

Output : 
```
0 [0]
1 [0, 1]
3 [0, 1, 5, 2]
6 [0, 1, 3]
7 [0, 1, 5, 2, 6, 7, 4]
2 [0, 1, 5]
5 [0, 1, 5, 2, 6]
6 [0, 1, 5, 2, 6, 7]
8 [0, 1, 5, 2, 6, 7, 8]
9 [0, 1, 5, 2, 6, 7, 8, 9]
```
