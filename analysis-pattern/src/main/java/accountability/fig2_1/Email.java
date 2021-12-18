package accountability.fig2_1;

import com.google.common.base.MoreObjects;

public class Email {
    private final String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("email", email)
                .toString();
    }
}
