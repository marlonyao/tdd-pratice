package marlonyao.leetcode.lcof.issue22;

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = listSize(head);
        return getKthFromStart(head, size - k);
    }

    private ListNode getKthFromStart(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    private int listSize(ListNode head) {
        int size = 0;
        for (;head != null; head = head.next) {
            size++;
        }
        return size;
    }
}