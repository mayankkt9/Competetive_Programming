package akuna_cap;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Akuna_round_2 {

	// Complete the validateAccountNumber function below
	static String validateAccountNumber(String accountNumber) {
		if (accountNumber.length() != 8)
			return "INVALID";
		
		String arr = accountNumber.substring(2);
		String checkSum = accountNumber.substring(0, 2);
		accountNumber = accountNumber.replaceAll(" ", "");
		if (accountNumber.length() <= 7)
			return "INVALID";

		if (accountNumber.length() != 8)
			return "INVALID";

		String ch = "0123456789ABCDEF";

		for (int i = 2; i < arr.length(); i++) {

			if (arr.charAt(i) <= 'F'
					&& ch.contains(String.valueOf(arr.charAt(i))))
				continue;
			else
				return "INVALID";

		}

		int num = Integer.parseInt(arr, 16);
		System.out.println("hey " + num);
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;

		}

		String hex = Integer.toHexString(sum);
		System.out.println("hex " + hex);
		if (hex.equalsIgnoreCase(checkSum)) {

			return "VALID";
		}

		return "INVALID";

		// TODO
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(validateAccountNumber(sc.nextLine()));
		}
	}
}