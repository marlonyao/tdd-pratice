package accountability.fig2_5.sales;

import accountability.fig2_5.Organization;

public class Division extends Organization {
    @Override
    public void addSalesSubsidiary(Organization subsidiary) {
        if (!(subsidiary instanceof SalesOffice)) {
            throw new IllegalArgumentException("Can only add SalesOffice for Division");
        }
        super.addSalesSubsidiary(subsidiary);
    }
}
