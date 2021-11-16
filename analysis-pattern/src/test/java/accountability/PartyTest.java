package accountability;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartyTest {
    @Test
    public void simple_address_book_model() {
        Party marlon = new Person("marlon",
                new TelephoneNumber("13511080333"),
                new Address("大屯路2号院"),
                new Email("yaolei@meituan.com")
        );
        assertThat(marlon.getName()).isEqualTo("marlon");
        System.out.println("marlon = " + marlon);

        Party meituan = new Organization("meituan",
                new TelephoneNumber("021-3333333"),
                new Address("望京北路"),
                new Email("aaaa@sankuai.com"));
        assertThat(meituan.getName()).isEqualTo("meituan");
        System.out.println("meituan = " + meituan);
    }
}
