package jul_19_long_challenge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode.ArrayUnit;

class Node {
	int data;
	boolean visited;

	public Node(int d) {
		// TODO Auto-generated constructor stub
		data = d;
		visited = false;

	}

}

class Node_Comparator implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		if (n1.data > n2.data)
			return 1;
		else if (n1.data < n2.data)
			return -1;
		else
			return 0;

	}
}

public class P7 {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int t = scan.scanInt();

		while (t > 0) {
			t--;

			int n = scan.scanInt();
			int k = scan.scanInt();

			int arr[] = new int[n];
			int current_length = n;
			for (int i = 0; i < n; i++) {
				arr[i] = scan.scanInt() * -1;
			}
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				arr[i] = arr[i] * -1;
			}
			System.out.println(Arrays.toString(arr));
			int sum = 0;
			for (int i = 0; i < k; i++) {
				int j = 0;
				for (j = 0; j < current_length; j++) {
					if (arr[j] > 2 * (arr[current_length - 1])) {
						arr[j] -= arr[current_length - 1];
						sum += arr[current_length - 1];
					} else
						break;
				}
				int flag=0;
				if (arr[j] == 2 * (arr[current_length - 1])) {
					sum += arr[current_length - 1];
				} else {
					sum += arr[j];
					flag=1;
				}

				for (int p = j; p < current_length - 1; p++) {
					arr[p] = arr[p + 1];
				}
				if(flag==1)
					current_length-=1;
				
				for(int pt=0;pt<current_length;pt++)
				{
					System.out.print(arr[pt]+" ");
				}
				System.out.println("");
			}
			System.out.println(sum);

		}
	}
}
