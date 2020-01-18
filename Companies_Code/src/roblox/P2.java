package roblox;

import java.util.Arrays;

public class P2 {
	public static void main(String[] args) {

		
		int grid[][]=new int[][]
				{{0,1,0,0},
				{0,0,0,0}};
		int k=1;
		String rules[]={"dead","alive","dead","dead","dead","dead","dead","dead","dead","dead"};
		
		
		System.out.println(Arrays.deepToString(solution(grid, k, rules)));
	}

	public static int[][] solution(int grid[][], int k, String[] rules) {
		int corners[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 },
				{ -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
		int lc[][] = new int[grid.length][grid[0].length];
		for (int l = 0; l < k; l++) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					int count = 0;
					for (int f = 0; f < 8; f++) {
						int r = i, c = j;
						r = r + corners[f][0];
						c = c + corners[f][1];
						if (r >= 0 && r < grid.length && c >= 0
								&& c < grid[0].length) {
							if (grid[r][c] == 1) {
								count++;
							}
						}
					}
					lc[i][j] = count;
				}
			}
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (rules[lc[i][j]].equals("alive")) {
						grid[i][j] = 1;
					} else {
						grid[i][j] = 0;
					}
				}
			}

		}

		return grid;
	}

}
