package intuit;
//
//import java.io.BufferedReader;
//
//import java.io.IOException;
//
//import java.io.InputStreamReader;
//
//import java.util.ArrayList;
//
//import java.util.List;
//
//public class P2 {
//
//	static void findWord(String word, String[][] grid) {
//
//		// Your output here. Prints to standard output.
//
//		List<int[]> res = new ArrayList<>();
//
//		boolean[][] visited = new boolean[grid.length][grid[0].length];
//
//		for (int i = 0; i < grid.length; i++) {
//
//			for (int j = 0; j < grid[0].length; j++) {
//
//				if (grid[i][j].charAt(0) == word.charAt(0)) {
//
//					dfs(grid, visited, word, res, i, j, 0, new ArrayList<int[]>());
//
//				}
//
//			}
//			
//			System.out.println("None");
//
//		}
//
//	}
//
//	public static void dfs(String[][] grid, boolean[][] visited, String word, List<int[]> res, int i, int j, int cur,
//			ArrayList<int[]> tmp) {
//
//		int[][] dirs = { { 0, 1 }, { 1, 0 } };
//
//		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]
//				|| grid[i][j].charAt((0)) != word.charAt(cur))
//
//			return;
//
//		if (cur == word.length() - 1 && grid[i][j].charAt(0) == word.charAt(word.length() - 1)) {
//
//			tmp.add(new int[] { i, j });
//
//			for (int[] t : tmp)
//
//				res.add(t);
//
//			return;
//
//		}
//
//		visited[i][j] = true;
//
//		tmp.add(new int[] { i, j });
//
//		for (int[] dir : dirs)
//
//		{
//
//			int ni = i + dir[0];
//
//			int nj = j + dir[1];
//
//			dfs(grid, visited, word, res, ni, nj, cur + 1, tmp);
//
//		}
//
//		tmp.remove(tmp.size() - 1);
//
//		visited[i][j] = false;
//
//	}
//
//	// DO NOT MODIFY MAIN()
//
//	public static void main(String[] args) {
//
//		String arg0 = null;
//
//		List<String[]> arg1 = new ArrayList<String[]>();
//
//		String line;
//
//		boolean first_arg = true;
////
////		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
////
////			while ((line = br.readLine()) != null) {
////
////				if (line.equals("")) {
////
////					continue;
////
////				}
////
////				if (first_arg) {
////
////					arg0 = line;
////
////					first_arg = false;
////
////				} else {
////
////					arg1.add(line.split(" "));
////
////				}
////
////			}
////
////		} catch (IOException e) {
////
////			e.printStackTrace();
////
////			return;
////
////		}
//
//		String[][] grid = arg1.toArray(new String[arg1.size()][]);
//
		
//		findWord(word1, grid1);
//
//	}
//
//}


import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.List;

import java.util.Arrays;

 

 

public class P2 {

 

  static List<int[]> findPath(String word, String[][] grid) {

    // Your output here. Prints to standard output.

    List<int[]> res = new ArrayList<>();

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {

      for (int j = 0; j < grid[0].length; j++) {

        if (grid[i][j].charAt(0) == word.charAt(0)) {

          dfs(grid, visited, word, res, i, j, 0, new ArrayList<int[]>());

        }

      }

    }

    return res;

  }

 

  

  static void findWord(String word, String[][] grid){

    List<int[]> paths = findPath(word, grid);

    if(paths.size() == 0 ){

      System.out.println("None");

    }

    for(int[] path: paths) {

      System.out.println(path[0] + " " + path[1]);

    }

  }

  public static void dfs(String[][] grid, boolean[][] visited,String word, List<int[]> res,int i, int j, int cur, ArrayList<int[]> tmp ) {

     int[][] dirs =  {{0,1},{1,0}};

 

    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j].charAt(0) != word.charAt(cur))

      return;

    if (cur == word.length() - 1 && grid[i][j].charAt(0) == word.charAt(word.length() - 1)) {

      tmp.add(new int[]{i, j});

      for (int[] t : tmp)

        res.add(t);

      return;

    }

 

  visited[i][j] = true;

  tmp.add(new int[] {i,j});

  for(int[] dir : dirs)

 

  {

    int ni = i + dir[0];

    int nj = j + dir[1];

    dfs(grid, visited, word, res, ni, nj, cur + 1, tmp);

  }

  tmp.remove(tmp.size()-1);
  visited[i][j] = false;
  }

 

  // DO NOT MODIFY MAIN()


  public static void main(String[] args) {

//    String arg0 = null;
//
//    List<String[]> arg1 = new ArrayList<String[]>();
//
// 
//
//    String line;
//
//    boolean first_arg = true;
//
//    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//
//      while ((line = br.readLine()) != null) {
//
//        if (line.equals("")) {
//
//          continue;
//
//        }
//
// 
//
//        if(first_arg) {
//
//          arg0 = line;
//
//          first_arg = false;
//
//        } else {
//
//          arg1.add(line.split(" "));
//
//        }
//
//      }
//
//    } catch (IOException e) {
//
//      e.printStackTrace();
//
//      return;
//
//    }
//
// 
//
//    String[][] grid = arg1.toArray(new String[arg1.size()][]);

    String[][] grid1 = { { "c", "r", "c", "a", "r", "s" }, { "a", "b", "i", "t", "n", "b" },
			{ "t", "f", "n", "n", "t", "i" }, { "x", "s", "c", "a", "t", "n" }, { "x", "x", "d", "d", "e", "a" },
			{ "s", "q", "w", "x", "s", "p" } };

	String word1 = "catnap";

    findWord(word1, grid1);

 

   

  }

}