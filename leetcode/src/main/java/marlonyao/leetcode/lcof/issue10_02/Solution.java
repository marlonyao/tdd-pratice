package marlonyao.leetcode.lcof.issue10_02;

class Solution {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int prev = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            int next = mod(prev + cur, 1000000007);
            prev = cur;
            cur = next;
        }
        return cur;
    }

    private int mod(int i, int n) {
        return i >= n ? i - n : i;
    }
}
