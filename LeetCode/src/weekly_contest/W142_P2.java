package weekly_contest;

public class W142_P2 {
	public static boolean carPooling(int[][] trips, int capacity) {

		int p=0,s=0,e=0,p1,s1,e1;
		p=trips[0][0];
		s=trips[0][1];
		e=trips[0][2];
		int tp=p;
		for(int i=1;i<trips.length;i++)
		{
			p1=trips[i][0];
			s1=trips[i][1];
			e1=trips[i][2];
			
			if(s1>=e1)
			{
				tp=tp-p;
				
			}
			
			
		}
		
		return false;
	}

	public static void main(String[] args) {

		
		int t[][]={{3,2,7},{3,7,9},{8,3,9}};
		System.out.println(carPooling(t,11));
	}
}
