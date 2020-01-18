package weekly_contest;

public class W147_P2 {
	public static void main(String[] args) {

		
		int grid[][]={{1,1,0,1}};
		largest1BorderedSquare(grid);
		
	}

	private static void largest1BorderedSquare(int[][] grid) {
		// TODO Auto-generated method stub
		
		int mat[][]=new int[grid.length][grid[0].length];
		
		
		for(int i =0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				if(grid[i][j]==1)
					mat[i][j]='X';
				else
					mat[i][j]='O';
			}
		}
		
		findSubSquare(mat);
		
	}

	//static int N = 6;

	static int getMin(int x, int y) {
		return (x < y) ? x : y;
	}
	static int findSubSquare(int mat[][]) {
		
		
		int max = 0;
		int hor[][] = new int[mat.length][mat[0].length];
		int ver[][] = new int[mat.length][mat[0].length];
		hor[0][0] = ver[0][0] = 'X';
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 'O')
					ver[i][j] = hor[i][j] = 0;
				else {
					hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
					ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
				}
			}
		}
		for (int i = mat.length - 1; i >= 1; i--) {
			for (int j = mat[0].length - 1; j >= 1; j--) {
				int small = getMin(hor[i][j], ver[i][j]);

				while (small > max) {
					if (ver[i][j - small + 1] >= small
							&& hor[i - small + 1][j] >= small) {
						max = small;
					}
					small--;
				}
			}
		}
		if(max>=1)
			return max;
		else
			return 1;
	}

}
