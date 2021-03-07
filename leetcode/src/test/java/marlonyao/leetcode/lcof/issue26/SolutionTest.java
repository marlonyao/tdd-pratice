package marlonyao.leetcode.lcof.issue26;

import org.junit.jupiter.api.Test;

import static marlonyao.leetcode.lcof.common.TreeNode.makeTree;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void isSubStructure() {
        Solution solution = new Solution();
        assertThat(solution.isSubStructure(makeTree(1), null)).isFalse();
        assertThat(solution.isSubStructure(makeTree(1), makeTree(1))).isTrue();
        assertThat(solution.isSubStructure(makeTree(1), makeTree(1, 2))).isFalse();
        assertThat(solution.isSubStructure(makeTree(1), makeTree(1, 2))).isFalse();
        assertThat(solution.isSubStructure(makeTree(1, 2, 3), makeTree(3, 1))).isFalse();
        assertThat(solution.isSubStructure(makeTree(3, 4, 5, 1, 2), makeTree(4, 1))).isTrue();
        assertThat(solution.isSubStructure(makeTree(1, 0, 1, -4, -3), makeTree(1, -4))).isFalse();
    }
}