package weekly_contest;

import java.util.Arrays;

public class W144_P4 {
	public static void main(String[] args) {
		String str="()(())()";
		maxDepthAfterSplit(str);
	}

	private static void maxDepthAfterSplit(String seq) {
		// TODO Auto-generated method stub
		int k=0;
		int maxk=0;
		int arr[]=new int [seq.length()];
		for(int i=0;i<seq.length();i++)
		{
			if(seq.charAt(i)=='(')
			{
				k++;
				if(maxk<k)
					maxk=k;
				if(maxk>k)
				{
					arr[i]=maxk;
				}
				else
				{
					arr[i]=k;
				}
			}
			
			else
			{
				if(maxk>k && k<=2)
				{
					arr[i]=maxk;
				}
				else
				{
					arr[i]=k;
				}
				k--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
}
