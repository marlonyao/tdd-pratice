package marlonyao.money;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static marlonyao.money.Money.powOf10;
import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
    public void should_create_from_cents() {
        Money money = Money.fromCents(101);
        assertThat(money.getScale()).isEqualTo(2);
        assertThat(money.getUnscaledValue()).isEqualTo(101);
    }
    
    @Test
    public void should_create_from_yuan() {
        Money money = Money.fromYuan(13);
        assertThat(money.getScale()).isEqualTo(0);
        assertThat(money.getUnscaledValue()).isEqualTo(13);
    }

    @Test
    public void should_create_from_BigDecimal() {
        Money money = Money.fromYuan(new BigDecimal("1.2"));
        assertThat(money.getScale()).isEqualTo(1);
        assertThat(money.getUnscaledValue()).isEqualTo(12);
    }

    @Test
    public void should_scale_not_be_larger_than_9() {
        assertThatThrownBy(() -> Money.fromYuan("0.1234567891"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Scale should not be larger than 9 but actual 10");

    }

    @Test
    public void should_create_from_string() {
        Money money = Money.fromYuan("1.2");
        assertThat(money.getScale()).isEqualTo(1);
        assertThat(money.getUnscaledValue()).isEqualTo(12);
    }

    @Test
    public void should_compare_yuan_with_yuan() {
        assertThat(Money.fromYuan(1)).isEqualByComparingTo(Money.fromYuan(1));
        assertThat(Money.fromYuan(10)).isLessThan(Money.fromYuan(12));
        assertThat(Money.fromYuan(12)).isGreaterThan(Money.fromYuan(10));
    }

    @Test
    public void should_compare_cents_with_yuan() {
        assertThat(Money.fromCents(100)).isEqualByComparingTo(Money.fromYuan(1));
        assertThat(Money.fromCents(99)).isLessThan(Money.fromYuan(1));
        assertThat(Money.fromYuan(1)).isGreaterThan(Money.fromCents(99));
    }

    @Test
    public void should_return_power_of_10() {
        assertThat(powOf10(0)).isEqualTo(1);
        assertThat(powOf10(1)).isEqualTo(10);
        assertThat(powOf10(2)).isEqualTo(100);
        assertThat(powOf10(3)).isEqualTo(1000);
        assertThat(powOf10(4)).isEqualTo(powOf10(3) * 10);
        assertThat(powOf10(5)).isEqualTo(powOf10(4) * 10);
        assertThat(powOf10(6)).isEqualTo(powOf10(5) * 10);
        assertThat(powOf10(7)).isEqualTo(powOf10(6) * 10);
        assertThat(powOf10(8)).isEqualTo(powOf10(7) * 10);
        assertThat(powOf10(9)).isEqualTo(powOf10(8) * 10);
    }

    @Test
    public void should_convert_to_BigDecimal() {
        BigDecimal value = new BigDecimal("1.2");
        assertThat(Money.fromYuan(value).toBigDecimal()).isEqualByComparingTo(value);
    }

    @Test
    public void should_convert_to_String() {
        assertThat(Money.fromCents(120).toString()).isEqualTo("1.2");
    }

    @Test
    public void should_convert_to_cents() {
        assertThat(Money.fromYuan("1.2").toCents()).isEqualTo(120L);
        assertThat(Money.fromYuan("1.231").toCents()).isEqualTo(123L);
        assertThat(Money.fromYuan("1.236").toCents()).isEqualTo(124L);
    }

    @Test
    public void should_convert_to_double() {
        assertThat(Money.fromYuan("1.23").toDouble()).isCloseTo(1.23, offset(1e-6));
    }
    
    @Test
    public void should_money_divide() {
        Money money = Money.fromYuan("1.2").divide(3, 2);
        assertThat(money).isEqualByComparingTo(Money.fromYuan("0.4"));

        money = Money.fromYuan("1.0").divide(3, 2);
        assertThat(money).isEqualByComparingTo(Money.fromYuan("0.33"));

        money = Money.fromYuan("2").divide(3, 2);
        assertThat(money).isEqualByComparingTo(Money.fromYuan("0.67"));

        money = Money.fromYuan("1.00").divide(3, 1);
        assertThat(money).isEqualByComparingTo(Money.fromYuan("0.3"));

        money = Money.fromYuan("2.00").divide(3, 1);
        assertThat(money).isEqualByComparingTo(Money.fromYuan("0.7"));
    }
}
