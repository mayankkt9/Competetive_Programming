package leetcode_array;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Number_Matching_Subsequence {
	public static int numMatchingSubseq(String S, String[] words) {

		
		HashMap<Character, Deque<String>> hm = new HashMap<Character, Deque<String>>();

		for(int i=0;i<S.length();i++)
		{
			hm.putIfAbsent(S.charAt(i), new LinkedList<String>());
		}
		
		for(int i=0;i<words.length;i++)
		{
			if(hm.containsKey(words[i].charAt(0)))
				hm.get(words[i].charAt(0)).addLast(words[i]);
		}
		
		int c=0;
		for(char ch : S.toCharArray())
		{
			Deque<String> dq=hm.get(ch);
			int size=dq.size();
			for(int i=0;i<size;i++)
			{
				String word=dq.removeFirst();
				
				if(word.length()==1)
				{
					c++;
					
				}
				else
				{
					if(hm.containsKey(word.charAt(1)))
						hm.get(word.charAt(1)).addLast(word.substring(1));
				}
				
			}
			
		}
		
		
		
		
		
		return c;
	}

	public static void main(String[] args) {

		String S="abcde";
		String words[]=new String[]{"a", "bb", "acd", "ace"};
		System.out.println(numMatchingSubseq(S,words));
		
	}
}
