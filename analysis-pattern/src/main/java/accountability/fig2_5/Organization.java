package accountability.fig2_5;

import java.util.ArrayList;
import java.util.List;

public abstract class Organization {
    private List<Organization> salesSubsidiaries = new ArrayList<>();
    private List<Organization> productLineSubsidiaries = new ArrayList<>();

    public void addSalesSubsidiary(Organization subsidiary) {
        salesSubsidiaries.add(subsidiary);
    }

    public List<Organization> getSalesSubsidiaries() {
        return salesSubsidiaries;
    }

    public void addProductLineSubsidiary(Organization subsidiary) {
        productLineSubsidiaries.add(subsidiary);
    }

    public List<Organization> getProductLineSubsidiaries() {
        return productLineSubsidiaries;
    }
}
