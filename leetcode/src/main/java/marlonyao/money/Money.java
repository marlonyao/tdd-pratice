package marlonyao.money;

import com.google.common.annotations.VisibleForTesting;

import java.math.BigDecimal;

public class Money implements Comparable<Money> {
    private static long[] powOf10Arr = {
            1, 10, 100, 1000, 10 * 1000, 100 * 1000, 1000 * 1000,
            10 * 1000 * 1000, 100 * 1000 * 1000, 1000 * 1000 * 1000
    };

    private final long unscaledValue;
    private final int scale;

    Money(long unscaledValue, int scale) {
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
        return unscaledValue / powOf10(scale - 2);
    }

    @VisibleForTesting
    static long powOf10(int n) {
        return powOf10Arr[n];
    }

    public double toDouble() {
        return (double)unscaledValue / powOf10(scale);
    }
}
