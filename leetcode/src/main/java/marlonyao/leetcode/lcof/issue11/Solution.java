package marlonyao.leetcode.lcof.issue11;

class Solution {
    public int minArray(int[] numbers) {
        return minArray(numbers, 0, numbers.length - 1);
    }

    private int minArray(int[] numbers, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        if (start == end) {
            return numbers[start];
        }

        if (numbers[start] < numbers[end]) {
            // 递增数组
            return numbers[start];
        }

        int mid = (start + end) / 2;
        if (numbers[start] < numbers[mid]) {
            // 左边数组递增，最小在右边
            return minArray(numbers, mid + 1, end);
        } else if (numbers[start] > numbers[mid]) {
            // 左边非递增，最小在左边
            return minArray(numbers, start + 1, mid);
        }
        // numbers[start] == numbers[mid] >= numbers[end]
        if (numbers[mid] > numbers[end]) {
            // 右边非递增，最小在右边
            return minArray(numbers, mid + 1, end);
        }
        // numbers[start] == numbers[mid] == numbers[end]
        // 两边都有可能，只能遍历
        return traversalMin(numbers, start, end);
    }

    private int traversalMin(int[] numbers, int start, int end) {
        int min = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
}