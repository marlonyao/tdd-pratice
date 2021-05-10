package marlonyao.leetcode.main.issue015;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        ValueIndex valueIndex = value2LastIndex(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (valueIndex.get(0).size() >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }
        if (valueIndex.firstPosIndex < 0) {
            return result;
        }

        // 先判断是否3个0，有先加入；作为特殊情况。
        //
        // init：负数索引 i = 0，如果第一个值不是负数，直接退出（不能，除非有3个0）；正数第一个索引 j。
        // step：选择 a[i, j]，剩下一个元素值为 v = -a[i] - a[j]。
        //   如果 v >= 0: 如果 v 存在，且v的索引 > j，则加入。否则：j++。
        //   如果 v < 0: 如果 v < a[i] 则 i++, j=第一个正数。（因为必定之前遍历过了）
        //      否则：如果 v == a[i]，如果 v 的索引 > i，加入。否则不加入。
        //      否则：如果 v > a[i]，加入。
        for (int i = 0; nums[i] < 0; i++) {
            for (int j = valueIndex.firstPosIndex; j < nums.length; j++) {
                if (isOk(nums, i, j, valueIndex)) {
                    addToResult(result, nums[i], nums[j], -nums[i] - nums[j]);
                }
            }
        }

        return result;
    }

    private void addToResult(List<List<Integer>> result, int num1, int num2, int num3) {
        List<Integer> list;
        if (num2 > num3) {
            list = Arrays.asList(num1, num3, num2);
        } else {
            list = Arrays.asList(num1, num2, num3);
        }
        if (!result.contains(list)) {
            result.add(list);
        }
    }

    private boolean isOk(int[] nums, int i, int j, ValueIndex valueIndex) {
        int v = -nums[i] - nums[j];
        Range index = valueIndex.get(v);
        if (index.size() == 0) {
            return false;
        }
        if (v < nums[i]) {
            return false;
        }
        if (v > 0 && v < nums[j]) {
            return false;
        }
        if (v == nums[i] && index.end == i) {
            return false;
        }
        if (v == nums[j] && index.end == j) {
            return false;
        }
        return true;
    }

    private ValueIndex value2LastIndex(int[] nums) {
        // init: i = 0,
        // INV: i是新值开始
        // progress: i变成另外一个新值，range(oldI, newI-1)
        ValueIndex result = new ValueIndex();
        int i = 0;
        while (i < nums.length) {
            int newI = findUntilNot(nums, i + 1, nums[i]);
            result.add(nums[i], new Range(i, newI - 1));
            i = newI;
        }
        return result;
    }

    private int findUntilNot(int[] nums, int startIndex, int value) {
        int i = startIndex;
        for (; i < nums.length; i++) {
            if (nums[i] != value) {
                break;
            }
        }
        return i;
    }

    static class ValueIndex {
        Map<Integer, Range> index = new HashMap<>();
        int firstPosIndex = -1;

        void add(int num, Range range) {
            if (firstPosIndex == -1 && num > 0) {
                firstPosIndex = range.start;
            }
            index.put(num, range);
        }

        public Range get(int value) {
            Range result = index.get(value);
            return result == null ? Range.EMPTY : result;
        }
    }

    static class Range {
        public static final Range EMPTY = new Range(0, -1);

        int start;
        int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int size() {
            return end - start + 1;
        }
    }
}
