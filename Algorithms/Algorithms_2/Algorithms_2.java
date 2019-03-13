package com.yunhao.Algorithms.Algorithms_2;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//simulate the add operation, caution the difference between pointer(in C++) and references(in JAVA) 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	
    	ListNode res = null, cur = null;
    	ListNode cursor1 = l1, cursor2 = l2;
    	int overflow = 0;
    	while(cursor1 != null && cursor2 != null) {
    		int sum = cursor1.val + cursor2.val + overflow;
    		if(cur == null) {
        		cur = new ListNode(sum % 10);
        		res = cur;
    		}
    		else {
    			cur.next = new ListNode(sum % 10);
    			cur = cur.next;
    		}
    		overflow = sum / 10;
    		
    		cursor1 = cursor1.next;
    		cursor2 = cursor2.next;
    	}
    	while(cursor1 != null) {
    		int sum = cursor1.val + overflow;
    		if(cur == null) {
        		cur = new ListNode(sum % 10);
        		res = cur;
    		}
    		else {
    			cur.next = new ListNode(sum % 10);
    			cur = cur.next;
    		}
    		overflow = sum / 10;
    		cursor1 = cursor1.next;
    	}
    	while(cursor2 != null) {
    		int sum = cursor2.val + overflow;
    		if(cur == null) {
        		cur = new ListNode(sum % 10);
        		res = cur;
    		}
    		else {
    			cur.next = new ListNode(sum % 10);
    			cur = cur.next;
    		}
    		overflow = sum / 10;
    		cursor2 = cursor2.next;
    	}
    	if(overflow != 0) {
    		if(cur == null) {
    			cur = new ListNode(overflow);
    			res = cur;
    		}
    		else {
    			cur.next = new ListNode(overflow);
        		cur = cur.next;
    		}
    	}
        return res;
    }
}

public class Algorithms_2 {
	public static void main(String[] args) {
		Solution solve = new Solution();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(1);
		ListNode l2 = new ListNode(5);
		ListNode ret = solve.addTwoNumbers(l1, l2);
	}
}
