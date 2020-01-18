package facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Phone_Screen_1_Group_of_friends {
	public static void main(String[] args) {
		
		String str = "10/01/2001 02:12 PM, UserA,UserB,ACCEPT| 11/04/2019 12:47 PM, UserC,UserE,ACCEPT|12/01/2012 05:23 PM, UserA,UserD,ACCEPT|10/12/2012 02:00 PM, UserE,UserB,ACCEPT|03/01/2001 03:32 PM, UserA,UserJ,ACCEPT|10/01/2019 02:37 PM, UserP,UserB,ACCEPT|03/01/2018 02:28 PM, UserC,UserD,REQUEST|10/12/2016 09:00 PM, UserA,UserB,REJECT|10/01/2005 02:34 PM, UserA,UserB,ACCEPT|03/19/2019 09:38 PM, UserD,UserB,REQUEST|10/18/2008 02:27 PM, UserC,UserB,REMOVE|10/24/2001 02:26 PM, UserA,UserE,REJECT|10/01/2019 03:34 PM, UserA,UserJ,REJECT|06/01/2016 05:00 PM, UserC,UserJ,ACCEPT|12/01/2018 02:22 PM, UserD,UserB,REQUEST|11/15/2019 02:00 PM, UserA,UserB,REQUEST|10/01/2001 03:17 PM, UserA,UserJ,REJECT|12/01/2019 02:32 PM, UserC,UserP,REJECT|10/01/2019 02:22 PM, UserE,UserE,ACCEPT|03/16/2019 02:13 PM, UserA,UserD,REQUEST|10/01/2001 03:21 PM, UserP,UserB,REQUEST|03/01/2019 05:00 PM, UserC,UserJ,REJECT|10/25/2018 05:15 PM, UserA,UserB,ACCEPT|12/27/2016 02:00 PM, UserE,UserP,REMOVE|10/01/2001 03:21 PM, UserC,UserB,REJECT|03/01/2005 02:58 PM, UserA,UserE,ACCEPT|12/29/2019 02:19 PM, UserE,UserB,REMOVE|10/27/2001 03:12 PM, UserC,UserB,REMOVE|06/01/2019 09:43 PM, UserA,UserB,REMOVE|12/01/2001 02:12 PM, UserC,UserD,ACCEPT|12/11/2005 09:26 PM, UserA,UserE,REMOVE|06/05/2019 02:00 PM, UserC,UserB,ACCEPT|09/02/2016 09:12 PM, UserJ,UserB,REMOVE|09/02/2016 09:12 PM, UserJ,UserB,REMOVE";
		
		
		String list[] = str.split("\\|");
		//System.out.println(Arrays.toString(list));
		
		List<String> word = Arrays.asList(list);
		solve(word);
		
		
	}
	
	
	
	public static void solve(List<String> csv	){
		HashMap<String,HashSet<String>> requestMap = new HashMap<>();
	       HashMap<String ,HashSet<String>> friendMap = new HashMap<>();
	       
	       for(String s : csv)
	       {
	           String[] entry = s.split(",");
	           if(entry[1].equals("REQUEST"))
	           {
	                 if(!requestMap.containsKey(entry[0]))
	                   requestMap.put(entry[2], new HashSet<String>());
	               
	               requestMap.get(entry[2]).add(entry[1]);
	          }
	          else if(entry[1].equals("ACCEPT"))
	          {
	              if(requestMap.containsKey(entry[0]))
	               {
	                   if(!friendMap.containsKey(entry[0]))
	                       friendMap.put(entry[0], new HashSet<String>());
	                   friendMap.get(entry[0]).add(entry[2]);
	                   if(!friendMap.containsKey(entry[2]))
	                       friendMap.put(entry[2], new HashSet<String>());
	                   friendMap.get(entry[2]).add(entry[0]);
	                   
	                   requestMap.remove(entry[0]);
	               }  
	          }
	          else if(entry[1].equals("REMOVE"))
	          {
	              friendMap.get(entry[0]).remove(entry[2]);
	              friendMap.get(entry[2]).remove(entry[0]);
	              
	              if(friendMap.get(entry[0].length()==0) != null)
	               friendMap.remove(entry[0]);
	           
	               if(friendMap.get(entry[2].length()==0) != null)
	               friendMap.remove(entry[2]);
	          }
	          else
	          {
	              requestMap.get(entry[0]).remove(entry[2]);
	              if(requestMap.get(entry[0]).size() == 0)
	               requestMap.remove(entry[0]);
	          }
	       
	       }
	}
}
