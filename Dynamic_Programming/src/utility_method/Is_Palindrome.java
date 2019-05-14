package utility_method;

public class Is_Palindrome {
	public static boolean solve(String str,int l,int r) {

		String s=str.substring(l,r+1);
		String rev=new StringBuffer(s).reverse().toString();
		if(s.equals(rev)) return true;
		else return false;
		
		//System.out.println(s);
		//return true;
	}

}
