package biweekly_contest;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class BW3_P2 {
	
	public static void main(String[] args) {
		String S="havefffffffff";
		int k=5;
		
		System.out.println(numKLenSubstrNoRepeats(S,k));
		
	}
	
public static int numKLenSubstrNoRepeats(String S, int K) {
	if(S.length()<K) return 0;
	
	LinkedHashMap<Character,Integer> hs = new LinkedHashMap<Character,Integer>();
	HashSet<Character> h=new HashSet<Character>();
	for(int i=0;i<K;i++)
	{
		if(hs.containsKey(S.charAt(i)))
		{
			h.add(S.charAt(i));
		}
		hs.put(S.charAt(i),hs.getOrDefault(S.charAt(i), 0)+1);
	}
	
	int i=K;
	int c=0;
	int j=1;
	if(h.size()==0) c++;
	while(i<S.length())
	{
		
		int c1=hs.get(S.charAt(j-1));
		hs.put(S.charAt(j-1),hs.getOrDefault(S.charAt(j-1), 0)-1);
		if(c1-1<2)
		{
			h.remove(S.charAt(j-1));
		}
	
		hs.put(S.charAt(i),hs.getOrDefault(S.charAt(i), 0)+1);
		int c2=hs.get(S.charAt(i));
		
		if(c2>1)
			h.add(S.charAt(i));
		
		if(h.size()==0)c++;
		
			
		i++;
		j++;
	}
	
	return c;
        
    }
}
