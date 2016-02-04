package shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import matrix.Matrix;
import utils.Pair;

/**
 * Dijkstra implementation
 * @author lev
 *
 */
public class Dijkstra extends AbstractShortestPath{
	
	private static final int Infinity = 999;
	List<Integer> weightList;
	List<Boolean> lockedList;
	List<Pair<Integer,Integer>> edgePaths;
	
	public Dijkstra(Matrix m) {
		super(m);
	}
	
	private void init() {
		weightList = new ArrayList<Integer>();
		for (int i = 0; i < this.matrix.size(); i++) {
			weightList.add(Infinity);
		}
		
		lockedList = new ArrayList<Boolean>();
		for (int i = 0; i < this.matrix.size(); i++) {
			lockedList.add(false);
		}
		
		edgePaths = new ArrayList<Pair<Integer,Integer>>();
	}
	
	private void updateWeightList(int vertex) {
		for (int i = 0; i < this.matrix.size(); i++) {
			if(this.matrix.get(vertex, i) + weightList.get(vertex) < weightList.get(i) && i!=vertex) {
				weightList.set(i, this.matrix.get(vertex, i) + weightList.get(vertex));
			}
		}
	}
	
	private int getNextVertexToProcess() {
		List<Integer> weightAuxiliaryList = new ArrayList<Integer>();
		for (int i = 0; i < this.matrix.size(); i++) {
			weightAuxiliaryList.add(weightList.get(i));
		}
		
		for (int i = 0; i < lockedList.size(); i++) {
			if(lockedList.get(i) == true) {
				weightAuxiliaryList.set(i, Infinity);
			}
			
		}
		return weightAuxiliaryList.indexOf(Collections.min(weightAuxiliaryList));
	}
	
	private int getPreviousVertex(int vertex) {
		List<Integer> findMinList = new ArrayList<Integer>();
		for (int i = 0; i < this.matrix.size(); i++) {
			if(matrix.get(i, vertex) < Infinity && lockedList.get(i)) {
				findMinList.add(matrix.get(i, vertex) + weightList.get(i));
			}
			else {
				findMinList.add(Infinity);
			}
		}
		return findMinList.indexOf(Collections.min(findMinList));
		
	}
	
	/* 
	 * @see shortestpath.AbstractShortestPath#getPaths(int)
	 */
	@Override
	public String getPaths(int start) {
		
		init();
		
		weightList.set(start, 0);
		
		int vertex = start;

		while(lockedList.contains(false)) {
			this.updateWeightList(vertex);
			
			lockedList.set(vertex, true);
			
			int nextVertex = getNextVertexToProcess();

			edgePaths.add(new Pair<Integer, Integer>(getPreviousVertex(nextVertex), nextVertex));
			vertex = nextVertex;
		}
		edgePaths.remove(edgePaths.size() - 1);
		
		System.out.println(weightList);
		System.out.println(edgePaths);
		
		String str = "";
		for (int i = 0; i < this.matrix.size(); i++) {
			str += weightList.get(i) + " ";
			
			int v = i;
			List<Integer> path = new ArrayList<Integer>();
			path.add(v);
			while(v!=start) {
				for (int j = 0; j < edgePaths.size(); j++) {
					if(edgePaths.get(j).getRight() == v) {
						path.add(0, edgePaths.get(j).getLeft());
						v = edgePaths.get(j).getLeft();
						break;
					}
				}
			}
			str += path.toString() + "\n";
			
		}
		System.out.println(str);
		
		return str;
	}

}
