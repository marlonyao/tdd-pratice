package marlonyao.leetcode.lcof.issue22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void getKthFromEnd() {
        Solution solution = new Solution();
        assertThat(solution.getKthFromEnd(makeList(1, 2, 3, 4), 1))
                .isEqualTo(makeList(4));

        assertThat(solution.getKthFromEnd(makeList(1, 2, 3, 4), 2))
                .isEqualTo(makeList(3, 4));

        assertThat(solution.getKthFromEnd(makeList(1, 2, 3, 4), 4))
                .isEqualTo(makeList(1, 2, 3, 4));

        assertThat(solution.getKthFromEnd(makeList(1, 2, 3, 4, 5), 2))
                .isEqualTo(makeList(4, 5));

    }

    private ListNode makeList(int... values) {
        return makeList(values, 0, values.length);
    }

    private ListNode makeList(int[] values, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return null;
        }
        ListNode head = new ListNode(values[startIndex]);
        head.next = makeList(values, startIndex + 1, endIndex);
        return head;
    }
}