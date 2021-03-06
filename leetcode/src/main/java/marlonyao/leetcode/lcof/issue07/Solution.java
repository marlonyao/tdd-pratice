package marlonyao.leetcode.lcof.issue07;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int root = preorder[0];

        // find root index
        int rootIndex = findRootIndex(root, inorder);
        // (0 .. rootIndex-1) rootIndex (rootIndex+1,...)
        int[] inorderLeftTree = new int[rootIndex];
        System.arraycopy(inorder, 0, inorderLeftTree, 0, inorderLeftTree.length);
        int[] inorderRightTree = new int[inorder.length - rootIndex - 1];
        System.arraycopy(inorder, rootIndex+1, inorderRightTree, 0, inorderRightTree.length);

        int[] preorderLeftTree = new int[rootIndex];
        // (1 .. rootIndex) (rootIndex+1,....)
        System.arraycopy(preorder, 1, preorderLeftTree, 0, preorderLeftTree.length);
        int[] preorderRightTree = new int[preorder.length - rootIndex - 1];
        System.arraycopy(preorder, rootIndex+1, preorderRightTree, 0, preorderRightTree.length);

        TreeNode result = new TreeNode(root);
        result.left = buildTree(preorderLeftTree, inorderLeftTree);
        result.right = buildTree(preorderRightTree, inorderRightTree);
        return result;
    }

    private int findRootIndex(int root, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        throw new IllegalArgumentException(String.format("%s not found in inorder", root));
    }
}
