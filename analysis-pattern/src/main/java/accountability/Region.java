package accountability;

public class Region extends Organization {
    @Override
    public void addSubsidiary(Organization subsidiary) {
        if (!(subsidiary instanceof Division)) {
            throw new IllegalArgumentException("Can only add Division for Region");
        }
        super.addSubsidiary(subsidiary);
    }
}
