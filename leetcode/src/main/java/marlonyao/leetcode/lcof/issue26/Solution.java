package marlonyao.leetcode.lcof.issue26;

import marlonyao.leetcode.lcof.common.TreeNode;

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return isSub(A, B);
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }

        return sameStructure(A, B)
                || isSub(A.left, B)
                || isSub(A.right, B);
    }

    private boolean sameStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return sameStructure(A.left, B.left) && sameStructure(A.right, B.right);
    }
}
