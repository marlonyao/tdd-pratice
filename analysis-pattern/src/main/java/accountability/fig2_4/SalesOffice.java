package accountability.fig2_4;

public class SalesOffice extends Organization {
    @Override
    public void addSubsidiary(Organization subsidiary) {
        throw new IllegalArgumentException("Can not add anything for SalesOffice");
    }
}
