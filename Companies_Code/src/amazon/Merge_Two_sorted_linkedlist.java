package amazon;

import java.util.LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Merge_Two_sorted_linkedlist {

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;

		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(4);
		m1.next = m2;
		m2.next = m3;
		m3.next = null;

		ListNode head = n1;
		ListNode head2 = m1;
		System.out.println(mergeTwoLists(head, head2));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode head1 = l1;
		ListNode head2 = l2;
		ListNode head3 = null;
		ListNode result = null;
		ListNode temp;

		if (l1 == null && l2 == null)
			return null;
		if (l1 != null && l2 == null)
			result = l1;
		if (l1 == null && l2 != null)
			result = l2;

		while (!(head1 == null || head2 == null)) {

			if (head1.val < head2.val) {
				temp = new ListNode(head1.val);
				head1 = head1.next;

			} else {
				temp = new ListNode(head2.val);
				head2 = head2.next;
			}

			if (head3 == null) {
				result = temp;
				head3 = temp;
			} else {
				head3.next = temp;
				head3=head3.next;
			}
			
		}
		if (head1 != null) {
			head3.next = head1;
		} else
			head3.next = head2;

		return result;

	}
}
