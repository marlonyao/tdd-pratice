package accountability;

import com.google.common.base.MoreObjects;

public class Organization extends Party {
    public Organization(String name, TelephoneNumber phone, Address address, Email email) {
        super(name, phone, address, email);
    }
}
