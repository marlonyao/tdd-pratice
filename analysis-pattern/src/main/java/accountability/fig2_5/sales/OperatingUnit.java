package accountability.fig2_5.sales;

import accountability.fig2_5.Organization;

public class OperatingUnit extends Organization {
    @Override
    public void addSalesSubsidiary(Organization subsidiary) {
        if (!(subsidiary instanceof Region)) {
            throw new IllegalArgumentException("Can only add Region for OperatingUnit");
        }
        super.addSalesSubsidiary(subsidiary);
    }
}
