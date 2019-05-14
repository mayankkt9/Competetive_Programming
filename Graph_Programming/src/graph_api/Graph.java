package graph_api;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph {

	private int V;
	private int E;
	private LinkedList<Integer> adj[];
	
	public Graph()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices");
		V=sc.nextInt();
		System.out.println("Enter number of edges");
		E=sc.nextInt();
		System.out.println("Enter Connecting edges in the format u v ");
		
		adj=new LinkedList[V];
		
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList<>();
		}
		for(int i=0;i<E;i++)
		{
			int v=sc.nextInt();
			int w=sc.nextInt();
			addEdge(v,w);
		}
	}
	
	public void addEdge(int v,int w)
	{
		adj[v].addFirst(w);
		adj[w].addFirst(v);	
	}
	
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	
	public void printGraph()
	{
		for(int i=0;i<V;i++)
		{
			System.out.print(i);
			for(Integer j : adj[i])
			{
				System.out.print("-"+j);
			}
			System.out.println();
		}
	}
	
	public LinkedList<Integer> adj(int v)
	{
		LinkedList<Integer> allAdjacent=new LinkedList<>();
		for(Integer j : adj[v])
		{
			allAdjacent.addFirst(j);
		}
		return allAdjacent;
	}
	
	public int degree(int v)
	{
		return adj[v].size();
	}
	
	public int maxDegree()
	{
		int max=0;
		for(int i=0;i<V;i++)
		{
			if(degree(i)>max)
				max=degree(i);
		}
		
		return max;
	}
	
	public int avgDegree()
	{
		return 2*E/V;
	}
	
	public int numberOfSelfLoop()
	{
		int count=0;
		for(int i=0;i<V;i++)
		{
			for(Integer j : adj[i])
			{
				if(j==i)
					count++;
			}
			
		}
		return count/2;
	}
	
	public static void main(String args[])
	{
		Graph g=new Graph();
		g.printGraph();
		
		
		
		
		
		
		
		
		//UNIT TEST
		
		/*
		LinkedList<Integer> adj=g.adj(9);
		for(Integer j : adj)
		{
			System.out.print("-"+j);
		}
		*/
		
		/*
		System.out.println(g.degree(0));
		System.out.println(g.degree(8));
		*/
		
		//System.out.println(g.maxDegree());
		//System.out.println(g.avgDegree());
		//System.out.println(g.numberOfSelfLoop());
	}
	
	
}
