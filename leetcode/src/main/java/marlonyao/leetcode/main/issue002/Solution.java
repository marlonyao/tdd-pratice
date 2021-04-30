package marlonyao.leetcode.main.issue002;

import marlonyao.leetcode.lcof.common.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private static ListNode ZERO = new ListNode(0);

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        if (l1 == null) {
            l1 = ZERO;
        }
        if (l2 == null) {
            l2 = ZERO;
        }

        int first = (carry + l1.val + l2.val) % 10;
        int nextCarry = (carry + l1.val + l2.val) / 10;
        return makeNode(first, addTwoNumbers(l1.next, l2.next, nextCarry));
    }

    private ListNode makeNode(int val, ListNode next) {
        ListNode result = new ListNode(val);
        result.next = next;
        return result;
    }
}
