/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Nov 22 18:39:00 2015
 ************************************************************************/

class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
		val = 0;
		next = null;
	}

	public ListNode(int v) {
		val = v;
		next = null;
	}

	public void print(int k) {
		ListNode p = this;
		System.out.print("[List]: ");
		for(int i=0; i<k-1; i++) {
			System.out.print(p.val + "->");
			p = p.next;
		}
		System.out.println(p.val);
	}
}

public class Solution {
	public static void insert(ListNode head, int value) {
		if(head==null) return;

		ListNode p = head, max = head;

		while(true) {
			if(p.val<=value && p.next.val>=value) {
				ListNode temp = p.next;
				p.next = new ListNode(value);
				p.next.next = temp;
				return;
			} 

			max = p.val > max.val ? p : max;

			p = p.next;

			if(p==head)
				break;
		}

		ListNode temp = max.next;
		max.next = new ListNode(value);
		max.next.next = temp;
	}

	public static void main(String[] args) {
		ListNode[] list = new ListNode[5];

		for(int i=4; i>=0; i--) {
			list[i] = new ListNode(2*i);
			list[i].next = (i==4) ? list[0] : list[i+1];
		}
		list[4].next = list[0];


		System.out.println("[Original List]");
		list[0].print(5);
		System.out.println("[After Insert 5]");
		insert(list[0], 5);
		list[0].print(6);

		System.out.println("[After Insert 100]");
		insert(list[0], 100);
		list[0].print(7);

		System.out.println("[After Insert -1]");
		insert(list[0], -1);
		list[0].print(8);

		System.out.println("[Original List]");
		list[3].print(8);
		System.out.println("[After Insert 5]");
		insert(list[3], 7);
		list[3].print(9);

	}
}