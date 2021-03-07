package marlonyao.leetcode.lcof.common;

import apple.laf.JRSUIUtils;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode makeNode(int val, TreeNode left, TreeNode right) {
        TreeNode result = new TreeNode(val);
        result.left = left;
        result.right = right;
        return result;
    }

    public static TreeNode makeTree(Integer... values) {
        if (values.length == 0) {
            return null;
        }
        Iterator<Integer> valuesItor = Arrays.asList(values).iterator();

        TreeNode root = new TreeNode(valuesItor.next());
        List<TreeNode> layer = Lists.newArrayList(root);
        outer:
        while (valuesItor.hasNext()) {
            List<TreeNode> nextLayer = Lists.newArrayList();
            for (TreeNode node : layer) {
                Integer left = valuesItor.hasNext() ? valuesItor.next() : null;
                Integer right = valuesItor.hasNext() ? valuesItor.next() : null;
                if (left != null) {
                    node.left = new TreeNode(left);
                    nextLayer.add(node.left);
                }
                if (right != null) {
                    node.right = new TreeNode(right);
                    nextLayer.add(node.right);
                }
            }
            layer = nextLayer;
        }
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
