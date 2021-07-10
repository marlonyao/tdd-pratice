package marlonyao.money;

import com.google.common.annotations.VisibleForTesting;

import java.math.BigDecimal;

public class Money implements Comparable<Money> {
    private static final int MAX_SCALE = 9;
    private static final long[] powOf10Arr = new long[MAX_SCALE + 1];

    private final long unscaledValue;
    private final int scale;

    static {
        initPowOf10Array();
    }

    Money(long unscaledValue, int scale) {
        if (scale > MAX_SCALE) {
            throw new IllegalArgumentException("Scale should not be larger than " + MAX_SCALE + " but actual " + scale);
        }
        this.unscaledValue = unscaledValue;
        this.scale = scale;
    }

    public static Money fromCents(long cents) {
        return new Money(cents, 2);
    }

    public static Money fromYuan(long yuan) {
        return new Money(yuan, 0);
    }

    public static Money fromYuan(BigDecimal yuan) {
        return new Money(yuan.unscaledValue().longValue(), yuan.scale());
    }

    public static Money fromYuan(String yuan) {
        return Money.fromYuan(new BigDecimal(yuan));
    }

    @VisibleForTesting
    long getUnscaledValue() {
        return unscaledValue;
    }

    @VisibleForTesting
    int getScale() {
        return scale;
    }

    @Override
    public int compareTo(Money other) {
        if (scale == other.scale) {
            return Long.compare(unscaledValue, other.unscaledValue);
        }
        if (scale > other.scale) {
            return Long.compare(unscaledValue, other.unscaledValue * powOf10(scale - other.scale));
        }
        return -other.compareTo(this);
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(unscaledValue, scale);
    }

    @Override
    public String toString() {
        // TODO: 使用性能更高的方式
        return toBigDecimal().stripTrailingZeros().toString();
    }

    public long toCents() {
        if (scale <= 2) {
            return unscaledValue * powOf10(2 - scale);
        }
        return roundDivide(unscaledValue, powOf10(scale - 2));
    }

    @VisibleForTesting
    static long powOf10(int n) {
        return powOf10Arr[n];
    }

    public double toDouble() {
        return (double)unscaledValue / powOf10(scale);
    }

    private static void initPowOf10Array() {
        int pow = 1;
        for (int i = 0; i <= MAX_SCALE; i++) {
            powOf10Arr[i] = pow;
            pow = 10 * pow;
        }
    }

    public Money divide(long n, int precision) {
        if (precision > scale) {
            long newUnscaledValue = roundDivide(this.unscaledValue * powOf10(precision - scale), n);
            return new Money(newUnscaledValue, precision);
        }
        return new Money(unscaledValue / n, scale)
                .truncatePrecision(precision);
    }

    private Money truncatePrecision(int precision) {
        if (scale <= precision) {
            return this;
        }
        long newUnscaledValue = roundDivide(this.unscaledValue, powOf10(scale - precision));
        return new Money(newUnscaledValue, precision);
    }

    /**
     * 考虑四舍五入的整数除法，比如 5 / 3 = 2（而不是默认的1）
     */
    private long roundDivide(long dividend, long n) {
        if (n == 1) {
            return dividend;
        }

        // TODO: may overflow!
        long resultMul10 = dividend * 10 / n;
        if (resultMul10 % 10 >= 5) {
            return resultMul10 / 10 + 1;
        }
        return resultMul10 / 10;
    }
}
