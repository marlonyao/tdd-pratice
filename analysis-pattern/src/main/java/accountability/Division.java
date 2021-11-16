package accountability;

public class Division extends Organization {
    @Override
    public void addSubsidiary(Organization subsidiary) {
        if (!(subsidiary instanceof SalesOffice)) {
            throw new IllegalArgumentException("Can only add SalesOffice for Division");
        }
        super.addSubsidiary(subsidiary);
    }
}
