package marlonyao.leetcode.lcof.issue10_1;

class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int prev = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            int next = mod(prev + cur, 1000000007);
            prev = cur;
            cur = next;
        }
        return cur;
    }

    private int mod(int next, int n) {
        if (next > n) {
            next -= 1000000007;
        }
        return next;
    }
}