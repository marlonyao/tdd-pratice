package accountability;

import com.google.common.base.MoreObjects;

public class Person {
    private final String name;
    private final TelephoneNumber phone;
    private final Address address;
    private final Email email;

    public Person(String name, TelephoneNumber phone, Address address, Email email) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("phone", phone)
                .add("address", address)
                .add("email", email)
                .toString();
    }
}
