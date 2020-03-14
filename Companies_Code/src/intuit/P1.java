package intuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1 {

	public static void main(String[] args) {
//		char[][] grid = { { 'c', 'r', 'c', 'a', 'r', 's' }, { 'a', 'b', 'i', 't', 'n', 'b' },
//				{ 't', 'f', 'n', 'n', 't', 'i' }, { 'x', 's', 'i', 'i', 'p', 't' } };
//		
		char[][] grid = { { 'c', 'r', 'c', 'a', 'r', 's' }, { 'a', 'b', 'i', 't', 'n', 'b' },
				{ 't', 'f', 'n', 'n', 't', 'i' }, { 'x', 's', 'c', 'a', 't', 'n' }, { 'x', 'x', 'd', 'd', 'e', 'a' },
				{ 's', 'q', 'w', 'x', 's', 'p' } };

		String word = "catnap";
		for (int[] path : findWord(grid, word)) {
			System.out.println(Arrays.toString(path));
		}
	}

	static int[][] dirs = { { 0, 1 }, { 1, 0 } };

	private static List<int[]> findWord(char[][] grid, String word) {
		List<int[]> res = new ArrayList<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == word.charAt(0)) {
					dfs(grid, visited, word, res, i, j, 0, new ArrayList<int[]>());
				}
			}
		}
		return res;
	}

	private static void dfs(char[][] grid, boolean[][] visited, String word, List<int[]> res, int i, int j, int cur,
			ArrayList<int[]> tmp) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]
				|| grid[i][j] != word.charAt(cur))
			return;
		if (cur == word.length() - 1 && grid[i][j] == word.charAt(word.length() - 1)) {
			tmp.add(new int[] { i, j });
			for (int[] t : tmp) {
				res.add(t);
			}
			return;
		}
		visited[i][j] = true;
		tmp.add(new int[] { i, j });
		for (int[] dir : dirs) {
			int ni = i + dir[0];
			int nj = j + dir[1];
			dfs(grid, visited, word, res, ni, nj, cur + 1, tmp);
		}
		tmp.remove(tmp.size() - 1);
		visited[i][j] = false;
	}
}