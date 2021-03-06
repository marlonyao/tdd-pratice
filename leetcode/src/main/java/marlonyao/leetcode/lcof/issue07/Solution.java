package marlonyao.leetcode.lcof.issue07;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(
            int[] preorder, int preorderStartIndex, int preorderEndIndex,
            int[] inorder, int inorderStartIndex, int inorderEndIndex) {
        if (preorderEndIndex == preorderStartIndex) {
            return null;
        }

        int root = preorder[preorderStartIndex];

        int rootInorderIndex = findIndex(root, inorder, inorderStartIndex, inorderEndIndex);
        int leftTreeSize = rootInorderIndex - inorderStartIndex;

        TreeNode result = new TreeNode(root);
        result.left = buildTree(preorder,
                preorderStartIndex + 1,
                preorderStartIndex + leftTreeSize + 1,
                inorder,
                inorderStartIndex,
                rootInorderIndex);
        result.right = buildTree(preorder,
                preorderStartIndex + leftTreeSize + 1,
                preorderEndIndex,
                inorder,
                rootInorderIndex + 1,
                inorderEndIndex);
        return result;
    }

    private int findIndex(int root, int[] inorder, int inorderStartIndex, int inorderEndIndex) {
        for (int i = inorderStartIndex; i < inorderEndIndex; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        throw new IllegalArgumentException(String.format("%s not found in inorder", root));
    }
}
