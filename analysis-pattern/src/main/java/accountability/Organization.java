package accountability;

import java.util.ArrayList;
import java.util.List;

public abstract class Organization {
    private List<Organization> subsidiaries = new ArrayList<>();

    public void addSubsidiary(Organization subsidiary) {
        subsidiaries.add(subsidiary);
    }

    public List<Organization> getSubsidiaries() {
        return subsidiaries;
    }
}
