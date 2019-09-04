package weekly_contest;

public class W147_P1 {
	public static void main(String[] args) {
		String board[] = { "abcde", "fghij", "klmno", "pqrst", "uvwxy", "z" };

		String target = "grfgruuzjrktmqkziczvhezkpjzzxrdofdsksssvqoqpvwybrfigkfekcuzqdopwkgwtajelpkpxymvzikrcyoglzejtgsgzstun";

		char ch='a',ch2='a';
		int i=0,j=0;
		String ans="";

		for(int k=0;k<target.length();k++)
		{
			int wch=0;
			int wb=0;
			ch=target.charAt(k);
			
			if(ch>=97&&ch<=101)
				wch=1;
			else if(ch>=102&&ch<=106)
				wch=2;
			else if(ch>=107&&ch<=111)
				wch=3;
			else if(ch>=112&&ch<=116)
				wch=4;
			else if(ch>=117&&ch<=121)
				wch=5;
			else
				wch=6;
				
			ch2=board[i].charAt(j);
			
			if(ch2>=97&&ch2<=101)
				wb=1;
			else if(ch2>=102&&ch2<=106)
				wb=2;
			else if(ch2>=107&&ch2<=111)
				wb=3;
			else if(ch2>=112&&ch2<=116)
				wb=4;
			else if(ch2>=117&&ch2<=121)
				wb=5;
			else
				wb=6;
			
			
			if(wch>wb)
			{
				for(int p =wb;p<wch;p++)
				{
					
					
					if(i==4 && wch>wb)
					{
						int pop=board[i].charAt(j)-117;
						for(int kl=0;kl<pop;kl++)
						{
							ans=ans+'L';
							j--;
						}
					}
					ans=ans+'D';
					i++;
					wb++;
					
					
				}
			}
			else
			{
				for(int p =wch;p<wb;p++)
				{
					ans=ans+'U';
					i--;
					
				}
			}
			
			if(i==5)j=0;
			
			while(board[i].charAt(j) != ch)
			{
				int diff=(int)ch-(int)board[i].charAt(j);
				if(diff>0){
					j++;
					ans=ans+'R';
				}
				else
				{
					j--;
					ans=ans+'L';
				}
			}
			ans=ans+'!';
		}
		System.out.println(ans);
	}
}
