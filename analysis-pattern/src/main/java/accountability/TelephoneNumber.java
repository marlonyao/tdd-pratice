package accountability;

import com.google.common.base.MoreObjects;

public class TelephoneNumber {
    private String number;

    public TelephoneNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("number", number)
                .toString();
    }
}
