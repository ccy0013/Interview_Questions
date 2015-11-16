/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Mon Nov 16 15:20:56 2015
 ************************************************************************/

class ListNode {
	int val;
	ListNode next;

	ListNode() {
		val = 0;
		next = null;
	}

	ListNode( int v ) {
		val = v;
		next = null;
	}

	public void print() {
		ListNode p = this;

		System.out.print("[List]: ");
		while(p.next!=null) {
			System.out.print(p.val + "->");
			p = p.next;
		}
		System.out.println(p.val);
	}
}

public class Solution {
	public static void reverseHalfList(ListNode head) {
		if(head==null || head.next==null)	return;

		ListNode p1 = head, p2 = head;

		while(p2.next!=null && p2.next.next!=null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}

		ListNode newHead = null;

		p2 = p1.next;

		while(p2!=null) {
			ListNode temp = p2.next;
			p2.next = newHead;
			newHead = p2;
			p2 = temp;
		}

		p1.next = newHead;
	}

	public static void main(String[] args) {
		ListNode[] list = new ListNode[10];
		for(int i=list.length-1; i>=0; i--) {
			list[i] = new ListNode(i+1);
			if(i!=list.length-1)
				list[i].next = list[i+1];
		} 

		list[0].print();

		reverseHalfList(list[0]);

		list[0].print();
	}
}
