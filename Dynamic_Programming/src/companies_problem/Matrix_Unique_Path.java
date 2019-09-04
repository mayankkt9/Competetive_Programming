package companies_problem;

import java.math.BigInteger;
import java.util.Scanner;

import utility_method.Generate_Factorial_Array;

public class Matrix_Unique_Path {
	public static int solve(int m, int n) {

		int x = m + n - 2;
		int y = n - 1;
		int z = x - y;
		long ans = 1;
		int y1 = 1, z1 = 1;
		System.out.println(x + " " + y + " " + z);
		int temp = 0;
		if (y < z)
			temp = y;
		else
			temp = z;

		z = Math.max(y, z);
		y = temp;

		for (int i = x; i >= 1; i--) {
			ans *= i;

			if (y >= y1 && ans % y1 == 0) {
				ans = ans / y1;
				y1++;
			}
			if (z >= z1 && ans % z1 == 0) {
				ans = ans / z1;
				z1++;
			}

		}

		return (int) ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solve(51, 9));
	}
}
