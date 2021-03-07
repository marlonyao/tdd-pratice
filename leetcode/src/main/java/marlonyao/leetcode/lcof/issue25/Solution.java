package marlonyao.leetcode.lcof.issue25;

import marlonyao.leetcode.lcof.common.ListNode;

class Solution {
    // TODO: 使用递归算法更简单
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);   // dummy node
        ListNode l1Cur = l1, l2Cur = l2, tail = head;
        // 两个指针(l1Cur和l2Cur)，谁小谁往前移，并把它添加到链表尾部(cur)。
        for (; l1Cur != null && l2Cur != null; tail = tail.next) {
            if (l1Cur.val < l2Cur.val) {
                tail.next = l1Cur;
                l1Cur = l1Cur.next;
            } else {
                tail.next = l2Cur;
                l2Cur = l2Cur.next;
            }
        }
        tail.next = l1Cur == null ? l2Cur : l1Cur;
        return head.next;
    }
}
