package akuna_cap;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Akuna1 {
	public static void main(String[] args) {

		ArrayList<String> lt = new ArrayList<>();
		lt.add("1563454984001|INSERT|test|123");
		lt.add("1563454984002|INSERT|test_2|234");
		lt.add("1563454984003|INSERT|test_3|345");
		

		HashTable obj = new HashTable(lt);
		System.out.println(obj.getTable());
		System.out.println(obj.getHighWatermark());
	}

}

class HashTable {
	static Map<String, String> hm = new HashMap<>();
	static Instant instant_event = Instant.ofEpochMilli(0);
	static ArrayList<String> rawEvents = new ArrayList<>();

	public HashTable(ArrayList<String> rawEvents) {
		this.rawEvents = rawEvents;
	}

	public static void solve() {
		int whether_event_occured = 0;
		for (int i = 0; i < rawEvents.size(); i++) {
			String str[] = rawEvents.get(i).split("\\|");
			if (str[1].equals("INSERT")) {
				if (hm.containsKey(str[2]) == false) {
					whether_event_occured = 1;
					hm.put(str[2], str[3]);
					instant_event = Instant.ofEpochMilli(Long.parseLong(str[0]));

				} else {
					instant_event = Instant.ofEpochMilli(Long.parseLong(str[0]))
							.plusMillis(1);
				}
			} else if (str[1].equals("UPSERT")) {
				whether_event_occured = 1;
				hm.put(str[2], str[3]);
				instant_event = Instant.ofEpochMilli(Long.parseLong(str[0]));
			} else {
				if (hm.containsKey(str[2])) {
					whether_event_occured = 1;
					hm.remove(str[2]);
					instant_event = Instant.ofEpochMilli(Long.parseLong(str[0]));
				}
			}

		}
		if (whether_event_occured == 0) {
			instant_event = Instant.EPOCH;
		}
	}

	public Map<String, String> getTable() {
		solve();
		return hm; // TODO
	}

	public Instant getHighWatermark() {
		return instant_event; // TODO
	}
}