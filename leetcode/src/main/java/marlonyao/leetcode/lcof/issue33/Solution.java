package marlonyao.leetcode.lcof.issue33;

import java.util.Arrays;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        int splitIndex = split(postorder);
        if (splitIndex == -1) {
            return false;
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, splitIndex)) &&
                verifyPostorder(Arrays.copyOfRange(postorder, splitIndex, postorder.length - 1));
    }

    private int split(int[] postorder) {
        int root = postorder[postorder.length - 1];
        int i = 0;
        for (; i < postorder.length - 1; i++) {
            if (postorder[i] > root) {
                for (int j = i + 1; j < postorder.length - 1; j++) {
                    if (postorder[j] < root) {
                        return -1;
                    }
                }
                break;
            }
        }
        return i;
    }
}
