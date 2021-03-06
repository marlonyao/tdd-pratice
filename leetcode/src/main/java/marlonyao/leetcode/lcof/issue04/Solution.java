package marlonyao.leetcode.lcof.issue04;

import java.util.Arrays;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] array : matrix) {
            if (Arrays.binarySearch(array, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}
