package graph_traversal;

import graph_api.Graph;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstPaths {
	private boolean marked[];
	private int edgeTo[];
	private int count;
	private int s;
	
	
	public DepthFirstPaths(Graph G,int s) {
		// TODO Auto-generated constructor stub
		this.s=s;
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		dfs(G,s);
	}
	
	public void dfs(Graph G,int v)
	{
		count ++;
		marked[v]=true;
		for(int j:G.adj(v))
		{
			if(!marked[j])
			{
				edgeTo[j]=v;
				dfs(G,j);
			}
		}
	}
	
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	public LinkedList<Integer> pathTo(int v)
	{
		LinkedList<Integer> ls=new LinkedList<>();
		if(!hasPathTo(v))
			return null;
		for(int x=v;x!=s;x=edgeTo[x])
			ls.addFirst(x);
		ls.addFirst(s);
		
		
		
		
		return ls;
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
		int s=sc.nextInt();
		DepthFirstPaths dfp=new DepthFirstPaths(G, s);
		
		
		
/*		
		LinkedList<Integer> ls=dfp.pathTo(4);
		if(ls!=null)
		for(Integer j : ls)
		{
			System.out.print("-"+j);
		}
		else
			System.out.println("NO PATH");
*/
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
*/
		
		
	}

}
