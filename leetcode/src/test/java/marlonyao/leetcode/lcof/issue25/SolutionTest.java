package marlonyao.leetcode.lcof.issue25;

import org.junit.jupiter.api.Test;

import static marlonyao.leetcode.lcof.common.ListNode.makeList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mergeTwoLists() {
        Solution solution = new Solution();
        assertThat(solution.mergeTwoLists(null, null)).isEqualTo(null);
        assertThat(solution.mergeTwoLists(makeList(1), null)).isEqualTo(makeList(1));
        assertThat(solution.mergeTwoLists(makeList(1), makeList(2))).isEqualTo(makeList(1, 2));
        assertThat(solution.mergeTwoLists(makeList(2), makeList(1))).isEqualTo(makeList(1, 2));
        assertThat(solution.mergeTwoLists(makeList(1, 3), makeList(2))).isEqualTo(makeList(1, 2, 3));
        assertThat(solution.mergeTwoLists(makeList(1), makeList(2, 3))).isEqualTo(makeList(1, 2, 3));
        assertThat(solution.mergeTwoLists(makeList(1, 3), makeList(2, 4))).isEqualTo(makeList(1, 2, 3, 4));
    }
}