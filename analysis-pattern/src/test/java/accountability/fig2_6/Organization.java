package accountability.fig2_6;

import com.google.common.base.MoreObjects;

public class Organization {
    private String name;

    public Organization(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}
