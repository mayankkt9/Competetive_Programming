package amazon;

import com.sun.glass.events.mac.NpapiEvent;

public class Copy_linked_list_random_pointer {

	public static void main(String[] args) {

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();

		n1.val = 1;
		n2.val = 2;
		n3.val = 3;
		n4.val = 4;
		n5.val = 5;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		n1.random = n3;
		n2.random = n1;
		n3.random = n5;
		n4.random = n2;
		n5.random = n4;

		Node head = n1;
		Node temp = head;
		System.out.println("Value\tNext\tRandom");
		// printLink(temp);

		Solution sc = new Solution();

		Node t1 = new Node();
		Node t2 = new Node();
		t1.val = -1;
		t1.next = t2;
		t1.random = null;
		head = t1;
		t2.val = 1;
		t2.random = null;
		printLink(head);

		Node head2 = sc.copyRandomList(head);
		// printLink(head2);

	}

	public static void printLink(Node temp) {
		while (temp != null) {

			if (temp.next != null)
				System.out.println(temp.val + "\t" + temp.next.val + "\t"
						+ temp.random);
			else
				System.out.println(temp.val + "\tnull\t" + temp.random);

			temp = temp.next;
		}
	}

	public static void printLinkSeq(Node temp) {
		while (temp != null) {

			if (temp.random != null) {
				if (temp.next != null)
					System.out.print(temp.val + "->" + temp.next.val + "("
							+ temp.random.val + ")");
				else
					System.out.print(temp.val + "->null(" + temp.random.val
							+ ")");

				temp = temp.next;
			} else {
				if (temp.next != null)
					System.out
							.print(temp.val + "->" + temp.next.val + "(null)");
				else
					System.out.print(temp.val + "->null(null)");
			}
		}
	}
}

class Node {
	public int val;
	public Node next;
	public Node random;

	public Node() {
	}

	public Node(int _val, Node _next, Node _random) {
		val = _val;
		next = _next;
		random = _random;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
};

class Solution {
	public static Node copyRandomList(Node head) {

		Node temp = head;
		if (head == null)
			return null;

		if (head.next == null) {
			Node n1 = new Node(head.val, head.next, head.random);
			if (head == head.random)
				n1.random = n1;
			return n1;
		}

		while (temp != null) {

			Node n1 = new Node(temp.val, temp.next, null);
			// n1.val = temp.val;
			// n1.next = temp.next;
			temp.next = n1;
			temp = temp.next.next;
		}
		temp = head;
		while (temp != null) {
			if (temp.random != null)
				temp.next.random = temp.random.next;
			else
				temp.next.random = null;
			temp = temp.next.next;
		}
		temp = head;
		Node temp1;
		Node head_res = temp.next;
		while (temp != null) {
			temp1 = temp.next;
			if (temp1.next == null) {
				temp.next = null;
				break;
			}
			temp.next = temp.next.next;
			temp = temp.next;
			temp1.next = temp1.next.next;
		}
		// Copy_linked_list_random_pointer.printLink(head_res);
		return head_res;

	}
}
