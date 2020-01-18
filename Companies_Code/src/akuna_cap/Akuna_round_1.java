package akuna_cap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Akuna_round_1 {
	
	static long total_distance=0;
	static PriorityQueue<String> pq_furthest=null;
    static PriorityQueue<String> pq_busy=null;
    static long max=0;
    static long max2=0;
    static HashMap<String, Long> hm = new HashMap<>();
    static HashMap<String, Long> hm2 = new HashMap<>();
	public static void main(String[] args) {
		
		
		
		System.out.println(Process("C0FFEE1C:CHI:NYC:714"));
		System.out.println(Process("0FF1CE18:LA:SEATTLE:961"));
		System.out.println(Process("C0FFEE1C:NYC:LA:2448"));
		System.out.println(Process("0FF1CE18:NYC:LA:26"));
		
	}
	
	
	
public static String Process(String line) {
        
        //long total_distance=0;
        String current_furthest="";
        String current_busy="";
        String inp[] = line.split(":");
        
        
        
        
        long inp3=Long.parseLong(inp[3]);
        if(hm.containsKey(inp[0])==false){
            hm.put(inp[0],inp3);
            
            if(inp3>max){
                max=inp3;
                current_furthest=inp[0];
                pq_furthest = new PriorityQueue<>();
                pq_furthest.add(inp[0]);
            }
            else
            {
                pq_furthest.add(inp[0]);
                current_furthest=pq_furthest.peek();
            }
        }
        else
        {
            long temp = hm.get(inp[0]);
            hm.put(inp[0],temp+inp3);
            long val=temp+inp3;
            
            if(val>max){
                max=val;
                current_furthest=inp[0];
                pq_furthest = new PriorityQueue<>();
                pq_furthest.add(inp[0]);
            }
            
            if(val==max){
                pq_furthest.add(inp[0]);
                current_furthest=pq_furthest.peek();
            }
        }
        if(hm2.containsKey(inp[1])==false){
            hm2.put(inp[1],Long.parseLong("1"));
            if(1>max2){
                max2=1;
                current_busy=inp[1];
                pq_busy=new PriorityQueue<>();
                pq_busy.add(inp[1]);
            }
            if(1==max2){
                pq_busy.add(inp[1]);
                current_busy=pq_busy.peek();
            }
        }
        else{
            hm2.put(inp[1],hm2.get(inp[1])+1);
            
            if(hm2.get(inp[1])+1 > max2){
                max2=hm2.get(inp[1])+1;
                current_busy=inp[1];
                pq_busy=new PriorityQueue<>();
                pq_busy.add(inp[1]);
            }
            if((hm2.get(inp[1])+1)==max2){
                pq_busy.add(inp[1]);
                current_busy=pq_busy.peek();
            }
            
        }
        if(hm2.containsKey(inp[2])==false){
            hm2.put(inp[2],Long.parseLong("1"));
             if(1>max2){
                max2=1;
                current_busy=inp[2];
                pq_busy=new PriorityQueue<>();
                pq_busy.add(inp[2]);
            }
            if(1==max2){
                pq_busy.add(inp[2]);
                current_busy=pq_busy.peek();
            }
        }
        else{
            hm2.put(inp[2],hm2.get(inp[2])+1);
             if(hm2.get(inp[2])+1 > max2){
                max2=hm2.get(inp[1])+1;
                current_busy=inp[2];
                pq_busy=new PriorityQueue<>();
                pq_busy.add(inp[2]);
            }
            if((hm2.get(inp[2])+1)==max2){
                pq_busy.add(inp[2]);
                current_busy=pq_busy.peek();
            }
            
            
            
        }
        
        
        total_distance+=inp3;
        
        String str = String.valueOf(total_distance)+":"+current_furthest+":"+current_busy;
        System.out.println(pq_furthest);
        return str;
        
    }
}
