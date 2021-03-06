package marlonyao.leetcode.lcof.issue07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void buildTree() {
        Solution solution = new Solution();
        // zero node
        assertThat(solution.buildTree(new int[]{}, new int[]{})).isEqualTo(null);
        // single node
        assertThat(solution.buildTree(new int[]{1}, new int[]{1})).isEqualTo(new TreeNode(1));

        assertThat(solution.buildTree(new int[]{2,1,3}, new int[]{1,2,3})).isEqualTo(
                makeTreeNode(2, new TreeNode(1), new TreeNode(3)));
    }

    static TreeNode makeTreeNode(int x, TreeNode left, TreeNode right) {
        TreeNode result = new TreeNode(x);
        result.left = left;
        result.right = right;
        return result;
    }
}