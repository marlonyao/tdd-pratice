package marlonyao.leetcode.lcof.issue14_2;

import java.math.BigInteger;

class Solution {
    public int cuttingRope(int n) {
        BigInteger result = BigInteger.ZERO;
        for (int m = 2; m <= n; m++) {
            // 分成 m 段，平均分应该就是最大的。
            // 也就是每个数基本是 n/m，剩下 n%m，给它们加1
            // 会有 n%m 个 (n/m+1)，(m - n%m) 个 n/m
            BigInteger multiply = BigInteger.valueOf(n/m+1).pow(n%m).multiply(BigInteger.valueOf(n/m).pow(m - n % m));
            if (multiply.compareTo(result) > 0) {
                result = multiply;
            }
        }
        return result.mod(BigInteger.valueOf(1000000007)).intValue();
    }
}