package marlonyao.leetcode.lcof.issue03;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
