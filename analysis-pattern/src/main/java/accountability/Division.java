package accountability;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private List<SalesOffice> salesOffices = new ArrayList<>();

    public void addSalesOffice(SalesOffice salesOffice) {
        salesOffices.add(salesOffice);
    }

    public List<SalesOffice> getSalesOffices() {
        return salesOffices;
    }
}
