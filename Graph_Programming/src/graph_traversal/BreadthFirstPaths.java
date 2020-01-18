package graph_traversal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import graph_api.Graph;

public class BreadthFirstPaths {
	
	private int MAXINT=Integer.MAX_VALUE;
	private int edgeTo[];
	private boolean marked[];
	private int distTo[];
	private LinkedList<Integer> ans;
	
	public BreadthFirstPaths(Graph G,int S) {
		
		ans = new LinkedList<>();
		edgeTo=new int[G.V()];
		marked=new boolean[G.V()];
		distTo=new int[G.V()];
		ans = bfs(G,S);
	}
	
	private LinkedList<Integer> getBFSPath()
	{
		return ans;
	}
	
	private LinkedList<Integer> bfs(Graph G,int S)
	{
		LinkedList<Integer> q = new LinkedList<>();
		 for(int v=0;v<G.V();v++)
			 distTo[v]=MAXINT;
		 distTo[S]=0;
		 marked[S]=true;
		 q.addLast(S);
		 ans.addLast(S);
		 while(!q.isEmpty())
		 {
			 int v=q.removeFirst();
			 for(int w:G.adj(v))
			 {
				 if(!marked[w])
				 {
					 marked[w]=true;
					 edgeTo[w]=v;
					 distTo[w]=distTo[v]+1;
					 q.addLast(w);
					 ans.addLast(w);
				 }
			 }
		 } 
		 return ans;
	}
	
	public BreadthFirstPaths(Graph G,Iterable<Integer> S) {
		edgeTo=new int[G.V()];
		marked=new boolean[G.V()];
		distTo=new int[G.V()];
		for(int v=0;v<G.V();v++)
			distTo[v]=MAXINT;
		bfs(G,S);
	}
	private void bfs(Graph G,Iterable<Integer> S)
	{
		 LinkedList<Integer> q = new LinkedList<>();
		 for(int i:S)
		 {
			 distTo[i]=0;
			 marked[i]=true;
			 q.addLast(i);
		 }
		 
		 while(!q.isEmpty())
		 {
			 int v=q.removeFirst();
			 for(int w:G.adj(v))
			 {
				 if(!marked[w])
				 {
					 marked[w]=true;
					 edgeTo[w]=v;
					 distTo[w]=distTo[v]+1;
					 q.addLast(w);
				 }
			 }
		 } 
	}
	
	
	
	
	public int distTo(int w)
	{
		return distTo[w];
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
		int i;
		for(i=v;distTo[i]!=0;i=edgeTo[i])
		{
			ls.addFirst(i);
		}
		ls.addFirst(i);
		return ls;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Graph G=new Graph();
		
		System.out.println("Enter the start vertex, where from your Breadth First Path Starts");
		int S=sc.nextInt();

		BreadthFirstPaths bfp=new BreadthFirstPaths(G, S);
		System.out.println(bfp.getBFSPath());
		
		
		
		
		
//		Iterable<Integer> itr=new LinkedList<>();
//		((LinkedList<Integer>) itr).add(5);
//		((LinkedList<Integer>) itr).add(0);
//		
		
		
		/*LinkedList<Integer> ls=bfp.pathTo(7);
		if(ls!=null)
		{
			for(Integer j : ls)
			{
				System.out.print("-"+j);
			}
			System.out.println();
			System.out.println("Dist "+bfp.distTo(6));
		}
		else
			System.out.println("NO PATH");
			
			*/
	
	/*
7
8
0 1
0 2
0 3
1 2
1 4
2 5
4 5
3 6
*/
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	


}
