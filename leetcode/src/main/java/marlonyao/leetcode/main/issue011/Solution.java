package marlonyao.leetcode.main.issue011;

class Solution {
    public int maxArea(int[] height) {
        // 初始：i = 0, j = h.length - 1
        // 如果 h[i] < h[j]:
        //   增加 i，直到 h[new_i] < h[i]，计算面积。
        // 如果 h[i] > h[j]
        //   减少 j，直到 h[new_j] > h[j]，计算面积。
        // 如果 h[i] == h[j]
        //   同时增加i，减少j
        // 一直到：i >= j。
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = area(height, i, j);
            if (area > max) {
                max = area;
            }

            if (height[i] < height[j]) {
                i = advanceUntilLargerThan(height, i + 1, j, height[i]);
            } else if (height[i] > height[j]) {
                j = backwardUntilLargerThan(height, j - 1, i, height[j]);
            } else {    // height[i] == height[j]
                i = advanceUntilLargerThan(height, i + 1, j, height[i]);
                j = backwardUntilLargerThan(height, j - 1, i, height[j]);
            }
        }
        return max;
    }

    private int advanceUntilLargerThan(int[] height, int startIndex, int endIndex, int value) {
        int i = startIndex;
        for (; i < endIndex; i++) {
            if (height[i] > value) {
                break;
            }
        }
        return i;
    }

    private int backwardUntilLargerThan(int[] height, int startIndex, int endIndex, int value) {
        int i = startIndex;
        for (; i > endIndex; i--) {
            if (height[i] > value) {
                break;
            }
        }
        return i;
    }

    private int area(int[] height, int i, int j) {
        return (j - i) * min(height[i], height[j]);
    }

    private int min(int x, int y) {
        return x < y ? x : y;
    }
}
