package jul_19_long_challenge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class P4_Interactive {

	public static Set<Integer> primeFactors(int n,int y) {

		Set<Integer> hs = new HashSet<>();
		while (n % 2 == 0) {
			if(2>y)
			hs.add(2);
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				if(i>y)
				hs.add(i);
				n /= i;
			}
		}

		if (n > 2)
			if(n>y)
			hs.add(n);

		return hs;
	}

	public static void main(String[] args) throws IOException {

		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		System.out.flush();
		int t = scan.scanInt();
		int x = 31623;
		int x2 = x * x;
		Set<Integer> h = null;
		while (t > 0) {
			t--;

			System.out.println("1 " + x);
			System.out.flush();
			int y = scan.scanInt();
			int z = x2 - y;

			h = primeFactors(z,y);
			
			
			
//			for (int p : h) {
//				if(p<y)
//					h.remove(p);
//			}
			int max = Collections.max(h);
			Set<Integer> temp = new HashSet<>();
			int root=(int) Math.sqrt(max);
			int root2=0;
			while (root >0) {
				root++;
				 root2=root*root;
				 temp = new HashSet<>();
				for (int p : h) {
					temp.add(root2 % p);
				}
				if (temp.size() == h.size())
					break;
				temp=null;
			}
			temp=null;
			//System.out.println("Root " + root);

			System.out.println("1 " + root);
			System.out.flush();
			int rem = scan.scanInt();
			for (int p : h) {
				if(p>y && root2%p==rem){
					System.out.println("2 "+p);
					System.out.flush();
					String str=scan.scanString();
					break;
				}
			}
			
			h = null;
		}
		
		
	}
}
