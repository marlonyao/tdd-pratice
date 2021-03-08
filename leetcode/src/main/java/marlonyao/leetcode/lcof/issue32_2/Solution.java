package marlonyao.leetcode.lcof.issue32_2;

import marlonyao.leetcode.lcof.common.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> layer = new ArrayDeque<>(1);
        layer.add(root);

        List<List<Integer>> result = new ArrayList<>();
        while (!layer.isEmpty()) {
            Queue<TreeNode> nextLayer = new ArrayDeque<>();
            List<Integer> layerList = new ArrayList<>();
            while (!layer.isEmpty()) {
                TreeNode node = layer.remove();
                layerList.add(node.val);
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }
            result.add(layerList);
            layer = nextLayer;
        };
        return result;
    }
}