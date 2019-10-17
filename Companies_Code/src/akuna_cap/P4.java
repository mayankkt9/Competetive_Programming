package akuna_cap;

import java.util.ArrayList;

public class P4 {
	public static void main(String[] args) {
		
//		StringBuilder sb = new StringBuilder(a.length * 2);
//		   for(byte b: a)
//		      sb.append(String.format("%02x", b));
//		   return sb.toString();
//		
		//byte[] b = new byte[]{0,0,0,0,0,1,6,'c',0,5,2,'d','c','f',4,1,0,0,0,0,0,e,7,4,6,5,7,3,7,4,5,f,6,b,6,5,7,9,5,f,3,0,3,9,3,8,3,1,3,2,0,0,1,0,7,4,6,5,7,3,7,4,5,f,7,6,6,1,6,c,7,5,6,5,5,f,3,1,3,2,3,8,3,7,3,6};
		String x = "0000016c052dcf4102000f746573745f6b65795f313233383937";

		ArrayList<String> arrlist = new ArrayList<>();
		while (x.length() >= 16) {
			int del = 0;
			String result = "";
			Long epoch = Long.valueOf(x.substring(0, 16), 16);
			result += epoch + "|";
			x = x.substring(16);
			String message_id = x.substring(0, 2);
			String message_name = "";
			if (message_id.charAt(1) == '0') {
				message_name = "INSERT";
			}
			if (message_id.charAt(1) == '1') {
				message_name = "UPSERT";
			}
			if (message_id.charAt(1) == '2') {
				message_name = "DELETE";
				del = 1;
			}
			x = x.substring(2);
			result += message_name + "|";
			int size = Integer.parseInt(x.substring(0, 4), 16);
			x = x.substring(4);
			String encmessage = x.substring(0, size * 2);
			System.out.println(size);
			x = x.substring(size * 2);
			String decmessage = unHex(encmessage);
			result += decmessage+"|";
			if (del == 0) {
				int size2 = Integer.parseInt(x.substring(0, 4), 16);
				x = x.substring(4);
				String encmessage2 = x.substring(0, size2 * 2);
				x = x.substring(size2 * 2);
				String decmessage2 = unHex(encmessage2);
				result += decmessage2+"|";
			}
			arrlist.add(result.substring(0,result.length()-1));
		}
		for (int i = 0; i < arrlist.size(); i++) {
			System.out.println(arrlist.get(i));
		}

	}

	public static String unHex(String arg) {

		String str = "";
		for (int i = 0; i < arg.length(); i += 2) {
			String s = arg.substring(i, (i + 2));
			int decimal = Integer.parseInt(s, 16);
			str = str + (char) decimal;
		}
		return str;
	}
}
