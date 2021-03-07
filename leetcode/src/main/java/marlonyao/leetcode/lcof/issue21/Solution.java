package marlonyao.leetcode.lcof.issue21;

class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (isEven(nums[i])) {
                swap(nums, i, j--);
            } else {
                i++;
            }
        }
        return nums;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
