package sorting;

import java.util.TreeMap;

public class TreeMap_learn {
	public static void main(String[] args) {
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		tmap.put(0, 0);
		tmap.put(1, 10);
		tmap.put(2, 20);
		tmap.put(3, 30);
		tmap.put(4, 40);
		tmap.put(5, 50);
		tmap.put(6, 60);
		tmap.put(7, 70);
		tmap.put(8, 80);
		tmap.put(9, 90);
		tmap.put(10, 100);
		tmap.put(11, 110);
		tmap.put(12, 120);
		tmap.put(13, 130);
		tmap.put(14, 140);
		
		System.out.println(tmap.lowerKey(-2));
		
	}
}
