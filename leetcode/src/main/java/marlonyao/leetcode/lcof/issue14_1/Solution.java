package marlonyao.leetcode.lcof.issue14_1;

class Solution {
    public int cuttingRope(int n) {
        int result = 0;
        for (int m = 2; m <= n; m++) {
            // 分成 m 段，平均分应该就是最大的。
            // 也就是每个数基本是 n/m，剩下 n%m，给它们加1
            // 会有 n%m 个 (n/m+1)，(m - n%m) 个 n/m
            int multiply = pow(n / m + 1, n % m) * pow(n / m, m - n % m);
            if (multiply > result) {
                result = multiply;
            }
        }
        return result;
    }

    private int pow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
}