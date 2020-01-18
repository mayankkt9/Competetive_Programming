package biweekly_contest;



public class BW3_P3 {
	
	public static void main(String[] args) {
		
		
		
		int A[][]=new int[][]{{5,4,5},{1,2,6},{7,4,6}};
		

int m = A.length;// row
int n = A[0].length; // column
int res=Integer.MAX_VALUE;
for (int i = 0; i < m; i++) {
	for (int j = 0; j < n; j++) {
		if (i == 0 && j != 0) {
			A[i][j] = A[i][j] + A[i][j - 1];
		} else if (i != 0 && j == 0) {
			A[i][j] = A[i][j] + A[i - 1][j];
		} else if (i == 0 && j == 0) {
			A[i][j] = A[i][j];
		} else {
			A[i][j] = Math.max(A[i][j - 1], A[i - 1][j])
					+ A[i][j];
			
			if(A[i][j - 1]>A[i - 1][j])
			{
				res=Math.min(res, A[i][j - 1]);
			}
			else
			{
				res=Math.min(res, A[i-1][j]);
			}
		}
	}
}
System.out.println(res);



		
		
		
	}
	
	
public int earliestAcq(int[][] logs, int N) {
	return N;
        
    }
}


