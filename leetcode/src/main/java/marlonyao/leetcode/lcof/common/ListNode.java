package marlonyao.leetcode.lcof.common;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode makeList(int... values) {
        return makeList(values, 0, values.length);
    }

    private static ListNode makeList(int[] values, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return null;
        }
        ListNode head = new ListNode(values[startIndex]);
        head.next = makeList(values, startIndex + 1, endIndex);
        return head;
    }
}
