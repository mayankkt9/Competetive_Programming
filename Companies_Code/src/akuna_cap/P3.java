package akuna_cap;

import java.nio.charset.StandardCharsets;

public class P3 {
	public static void main(String[] args) {

		String result = "";
		int del = 0;
		String x = "0000016c052dcf4100000e746573745f6b65795f30393831320010746573745f76616c75655f3132383736";
		String y = "0000016e5939b34201000d746573745f6b65795f303938310010746573745f76616c75655f303938313200000254d9d2df4302000d746573745f6b65795f303938310000033dae77ef44010010746573745f6b65795f303931323338310013746573745f76616c75655f303938313132333200000426831cff45010010746573745f6b65795f303938363738310013746573745f76616c75655f30393233343831320110016c052dcf4";
		x = y;
		Long epoch = Long.valueOf(x.substring(0, 16), 16);
		String message_name = "";
		x = x.substring(16);

		String message_id = x.substring(0, 2);
		if (message_id.charAt(message_id.length() - 1) == '0') {
			message_name = "INSERT";
		}
		if (message_id.charAt(message_id.length() - 1) == '1') {
			message_name = "UPSERT";
		}
		if (message_id.charAt(message_id.length() - 1) == '2') {
			message_name = "DELETE";
			del = 1;
		}
		x = x.substring(2);
		result = epoch + "|" + message_name + "|";
		String testkeyvalue = "";
		while (x.length() >= 16) {
			int size = Integer.parseInt(x.substring(0,4),16);
			x=x.substring(4);
			String encmessage=x.substring(0,size*2);
			x=x.substring(size*2);
			String decmessage=unHex(encmessage);
			testkeyvalue+=decmessage+"|";
		}
		
		System.out.println(result+testkeyvalue);
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
