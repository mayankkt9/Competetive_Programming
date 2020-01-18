package akuna_cap;

import java.util.ArrayList;

public class Akuna2 {
	public static void main(String[] args) {

		
		byte bt[] = new byte[30];
		Solution obj = new Solution();
		
		
		//byte bt1[] = new byte[]{0,0,0,0,0,1,6,c,0,5,2,d,c,f,4,1,0,0,0,0,0,e,7,4,6,5,7,3,7,4,5,f,6,b,6,5,7,9,5,f,3,0,3,9,3,8,3,1,3,2,0,0,1,0,7,4,6,5,7,3,7,4,5,f,7,6,6,1,6,c,7,5,6,5,5,f,3,1,3,2,3,8,3,7,3,6};
		
		
		System.out.println("1563454984001".getBytes());
	}
}

class Solution {
	/**
	 * A class which wraps a raw binary WAL and reconstructs DML Events.
	 */
	public static class WAL {
		/**
		 * Construct the WAL
		 * 
		 * @param input
		 *            the raw binary WAL
		 */
		public WAL(byte[] input) {
			// TODO
		}

		/**
		 * Retrieve all events contained within the WAL as their string values
		 * in time order DML Event String Format:
		 * "<epoch_milli>|<message_name>|<key>|<value>"
		 * 
		 * @return a time-ordered sequence of DML Event strings
		 */
		public ArrayList<String> getEvents() {
			return null;
			// TODO
		}
	}
}
