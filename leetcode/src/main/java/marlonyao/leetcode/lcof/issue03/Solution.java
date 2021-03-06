package marlonyao.leetcode.lcof.issue03;

class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] set = new int[nums.length];

        for (int num : nums) {
            if (set[num] > 0) {
                return num;
            }
            set[num] = 1;
        }
        return -1;
    }
}