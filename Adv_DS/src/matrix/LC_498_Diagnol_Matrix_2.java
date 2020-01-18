package matrix;

public class LC_498_Diagnol_Matrix_2 {
	public static void main(String[] args) {
		
	}
}

class Solution12 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
			return new int[0];
        int n = matrix.length;
        int m = matrix[0].length;
        int total_sum = n+m-2;
        int i=0,j=0;
        int result[]= new int[n*m];
        int index=0;
        for(int sum=0;sum<=total_sum;sum++){
            for(int k=0;k<=sum;k++){
                i=k;
                j=sum-i;
                if(sum%2==0){
                    i=i^j^(j=i);
                } 
                   // 
                if(i>=n||j>=m||index>=n*m) 
                    continue;
                
                result[index]=matrix[i][j];
                index++;
            }
        }
        return result;
        
        
    }
    // public void swap(Integer i,Integer j){
    //     Integer temp = i;
    //     i = j;
    //     j = temp;
    // }
}