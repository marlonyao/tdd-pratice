package accountability.fig2_5.sales;

import accountability.fig2_5.Organization;

public class SalesOffice extends Organization {
    @Override
    public void addSalesSubsidiary(Organization subsidiary) {
        throw new IllegalArgumentException("Can not add anything for SalesOffice");
    }
}
