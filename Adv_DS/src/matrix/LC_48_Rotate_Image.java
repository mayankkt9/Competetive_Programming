package matrix;

public class LC_48_Rotate_Image {
	public static void main(String[] args) {
		
	}
}


class Solution11 {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            int head = 0;
            int tail = m-1;
            
            for(int j=0;j<m/2;j++){
                int temp = matrix[head][i];
                matrix[head][i] = matrix[tail][i];
                matrix[tail][i] = temp;
                head++;
                tail--;
            }
        }
        
       // System.out.println(Arrays.deepToString(matrix));
        
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
    
}