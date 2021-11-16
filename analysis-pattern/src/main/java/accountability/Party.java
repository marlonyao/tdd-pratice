package accountability;

import com.google.common.base.MoreObjects;

public class Party {
    protected final String name;
    protected final TelephoneNumber phone;
    protected final Address address;
    protected final Email email;

    public Party(String name, TelephoneNumber phone, Address address, Email email) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", getName())
                .add("phone", phone)
                .add("address", address)
                .add("email", email)
                .toString();
    }
}
