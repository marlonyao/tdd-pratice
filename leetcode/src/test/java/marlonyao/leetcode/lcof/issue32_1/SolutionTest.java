package marlonyao.leetcode.lcof.issue32_1;

import org.junit.jupiter.api.Test;

import static marlonyao.leetcode.lcof.common.TreeNode.makeTree;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void levelOrder() {
        Solution solution = new Solution();
        assertThat(solution.levelOrder(null)).isEmpty();
        assertThat(solution.levelOrder(makeTree(1))).containsExactly(1);
        assertThat(solution.levelOrder(makeTree(1, 2))).containsExactly(1, 2);
        assertThat(solution.levelOrder(makeTree(1, null, 2, 3, null, 4))).containsExactly(1, 2, 3, 4);
        assertThat(solution.levelOrder(makeTree(3, 9, 20, null, null, 15, 7))).containsExactly(3, 9, 20, 15, 7);
    }
}