package marlonyao.leetcode.main.issue137;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 找到一个数，如果遇到重复的数，就抛弃。
    // 选择下一个数。是不是总能选择到下一个数？
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
