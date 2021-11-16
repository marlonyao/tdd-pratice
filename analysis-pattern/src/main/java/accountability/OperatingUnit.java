package accountability;

public class OperatingUnit extends Organization {
    @Override
    public void addSubsidiary(Organization subsidiary) {
        if (!(subsidiary instanceof Region)) {
            throw new IllegalArgumentException("Can only add Region for OperatingUnit");
        }
        super.addSubsidiary(subsidiary);
    }
}
