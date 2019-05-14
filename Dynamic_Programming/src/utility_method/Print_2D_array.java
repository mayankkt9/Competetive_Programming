package utility_method;

public class Print_2D_array {
	public static void solve(int arr[][]) {

		int rows=arr.length;
		int columns=arr[0].length;
		
		for(int i=0;i<rows;i++)
		{
			System.out.print("[ ");
			for(int j=0;j<columns;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.print("]");
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static void solve(boolean arr[][]) {

		int rows=arr.length;
		int columns=arr[0].length;
		
		for(int i=0;i<rows;i++)
		{
			System.out.print("[ ");
			for(int j=0;j<columns;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.print("]");
			System.out.println();
		}
		System.out.println();
		
	}
	
	
	public static void solve(Score arr[][]) {

		int rows=arr.length;
		int columns=arr[0].length;
		
		for(int i=0;i<rows;i++)
		{
			System.out.print("[ ");
			for(int j=0;j<columns;j++)
			{
				System.out.print(arr[i][j].f+","+arr[i][j].s+"\t");
			}
			System.out.print("]");
			System.out.println();
		}
		System.out.println();
		
	}

	
}
