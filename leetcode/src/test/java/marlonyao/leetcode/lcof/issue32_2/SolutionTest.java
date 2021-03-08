package marlonyao.leetcode.lcof.issue32_2;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.ImmutableList.of;
import static marlonyao.leetcode.lcof.common.TreeNode.makeTree;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void levelOrder() {
        Solution solution = new Solution();
        assertThat(solution.levelOrder(null)).isEmpty();
        assertThat(solution.levelOrder(makeTree(1))).isEqualTo(
                of(of(1)));

        assertThat(solution.levelOrder(makeTree(1, 2))).isEqualTo(
                of(of(1), of(2)));
        assertThat(solution.levelOrder(makeTree(1, null, 2))).isEqualTo(
                of(of(1), of(2)));
        assertThat(solution.levelOrder(makeTree(1, null, 2, 3, null, 5))).isEqualTo(
                of(of(1), of(2), of(3), of(5)));
        assertThat(solution.levelOrder(makeTree(3, 9, 20, null, null, 15, 7))).isEqualTo(
                of(of(3), of(9, 20), of(15, 7)));
    }
}