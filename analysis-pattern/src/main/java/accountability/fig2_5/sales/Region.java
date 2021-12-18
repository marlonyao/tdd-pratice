package accountability.fig2_5.sales;

import accountability.fig2_5.Organization;

public class Region extends Organization {
    @Override
    public void addSalesSubsidiary(Organization subsidiary) {
        if (!(subsidiary instanceof Division)) {
            throw new IllegalArgumentException("Can only add Division for Region");
        }
        super.addSalesSubsidiary(subsidiary);
    }
}
