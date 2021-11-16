package accountability;

import com.google.common.base.MoreObjects;

public class Person extends Party {

    public Person(String name, TelephoneNumber phone, Address address, Email email) {
        super(name, phone, address, email);
    }

}
