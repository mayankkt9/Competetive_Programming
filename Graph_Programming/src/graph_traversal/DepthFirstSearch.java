package graph_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import graph_api.Graph;

public class DepthFirstSearch {
	
	private boolean marked[];
	private int count;
	private ArrayList<Integer> al;
	public DepthFirstSearch(Graph G,int s) {
		// TODO Auto-generated constructor stub
		al  = new ArrayList<>(); 
		al.add(s);
		marked=new boolean[G.V()];
		al=dfs(G,s);
	}
	
	public ArrayList<Integer> getDFSPath()
	{
		return al;
	}
	
	public ArrayList<Integer> dfs(Graph G,int v)
	{
		count ++;
		marked[v]=true;
		for(int j:G.adj(v))
		{
			if(!marked[j])
			{
				al.add(j);
				//System.out.print(j+"-");
				dfs(G,j);
			}
		}
		return al;
	}
	
	public int count()
	{
		return count;
	}
	
	public boolean isConnected(Graph G)
	{
		if(count!=G.V())
			return false;
		else
			return true;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Graph G=new Graph();
		System.out.println("Enter the vertex you want to start from");
		int s=sc.nextInt();
		DepthFirstSearch dfsobj=new DepthFirstSearch(G, s);
		ArrayList<Integer> al = dfsobj.dfs(G, s);
		//System.out.println(al);
		System.out.println(dfsobj.getDFSPath());
		
		
/*		System.out.println(dfs.isConnected(G));

7
7
0 1
0 5
1 2
1 5
2 3
3 5
6 4
0


Enter number of vertices
5
Enter number of edges
7
Enter Connecting edges in the format u v 
0 1
1 2
2 3
3 4
0 4
1 4
1 3
Enter the start vertex, where from your Breadth First Path Starts
0
*/
		
		
	}
}
