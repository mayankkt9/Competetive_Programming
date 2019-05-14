package graph_application;

import graph_api.Graph;

import java.util.LinkedList;


public class ConnectedComponents {
	private boolean[] marked;// has vertex v been traversed
	private int[] id; // id of given component containing vertex v
	private int[] size; // size gives the number of vertices in a given
						// component
	private int count; // counts the number of components in a given graph

	public ConnectedComponents(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	// depth-first search for a Graph
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		size[count]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public int id(int v) {
		validateVertex(v);
		return id[v];
	}

	public int size(int v) {
		validateVertex(v);
		return size[id[v]];
	}

	public int count() {
		return count;
	}

	public boolean connected(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		return id(v) == id(w);
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v
					+ " is not between 0 and " + (V - 1));
	}

	public static void main(String[] args) {
		Graph G = new Graph();
		ConnectedComponents cc = new ConnectedComponents(G);

		// number of connected components
		int m = cc.count();
		System.out.println(m + " components");

		// compute list of vertices in each connected component
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] components = (LinkedList<Integer>[]) new LinkedList[m];
		for (int i = 0; i < m; i++) {
			components[i] = new LinkedList<Integer>();
		}
		for (int v = 0; v < G.V(); v++) {
			components[cc.id(v)].addFirst(v);
		}

		// print results
		for (int j = 0; j < m; j++) {
			for (int v : components[j]) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
		
		System.out.println(cc.id(2));
		System.out.println(cc.size(0));
		
		
	}

}





/*
 12 14
 0 1
 0 3
 0 4
 1 2
 1 3
 1 4
 2 4
 5 6
 5 7
 6 7
 6 8
 7 8
 9 10
 9 11
 
 
 
*/
