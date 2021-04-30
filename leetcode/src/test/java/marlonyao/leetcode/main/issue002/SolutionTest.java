package marlonyao.leetcode.main.issue002;

import org.junit.jupiter.api.Test;

import static marlonyao.leetcode.lcof.common.ListNode.makeList;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.addTwoNumbers(makeList(2, 4, 3), makeList(5, 6, 4)))
                .isEqualTo(makeList(7, 0, 8));
    }
}