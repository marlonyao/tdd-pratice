package accountability;

import org.junit.jupiter.api.Test;

public class PartyTest {
    @Test
    public void simple_address_book_model() {
        Person marlon = new Person("marlon",
                new TelephoneNumber("13511080333"),
                new Address("大屯路2号院"),
                new Email("yaolei@meituan.com")
        );
        System.out.println("marlon = " + marlon);

        Organization meituan = new Organization("meituan",
                new TelephoneNumber("021-3333333"),
                new Address("望京北路"),
                new Email("aaaa@sankuai.com"));

        System.out.println("meituan = " + meituan);
    }
}
