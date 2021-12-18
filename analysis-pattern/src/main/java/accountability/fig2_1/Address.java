package accountability.fig2_1;

import com.google.common.base.MoreObjects;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("address", address)
                .toString();
    }
}
