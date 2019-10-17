package weekly_contest;

public class W154_P1 {
	public static void main(String[] args) {
		String text = "leetcode";
		System.out.println(maxNumberOfBalloons(text));

	}

	public static int maxNumberOfBalloons(String text) {

		int min=0;
		int b=0,a=0,l=0,o=0,n=0;
		for (int i = 0; i < text.length(); i++) {

			
			if(text.charAt(i)=='b')
				b++;
			if(text.charAt(i)=='a')
				a++;
			if(text.charAt(i)=='l')
				l++;
			if(text.charAt(i)=='o')
				o++;
			if(text.charAt(i)=='n')
				n++;
			
			
			
			
			
			
			
		}
		o=o/2;
		l=l/2;
		min=Math.min(b,a);
		min=Math.min(min,l);
		min=Math.min(min,o);
		min=Math.min(min,n);
		return min;
	}
}
