package marlonyao.leetcode.lcof.issue16;

class Solution {
    public double myPow(double base, int exponent) {
        if (exponent < 0) {
            if (exponent == Integer.MIN_VALUE) {
                return 1 / (base * myPow(base, -(exponent + 1)));
            }
            return 1 / myPow(base, -exponent);
        }

        double[] pow2 = new double[32];
        pow2[0] = base;
        for (int i = 1; i < 32; i++) {
            pow2[i] = pow2[i - 1] * pow2[i - 1];
        }

        double result = 1.0;
        for (int i = 0; i < 32; i++) {
            if ((exponent & (1 << i)) > 0) {
                result *= pow2[i];
            }
        }
        return result;
    }
}