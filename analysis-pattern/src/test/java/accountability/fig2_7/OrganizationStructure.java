package accountability.fig2_7;

public class OrganizationStructure {
    private final OrganizationStructureType type;
    private final Organization subsidiary;
    private final Organization parent;

    public OrganizationStructure(OrganizationStructureType type, Organization subsidiary, Organization parent) {
        if (!type.isAllowed(subsidiary.getClass(), parent.getClass())) {
            throw new IllegalArgumentException(String.format("Not allow %s report to %s",
                    subsidiary.getClass().getSimpleName(),
                    parent.getClass().getSimpleName()));
        }
        this.type = type;
        this.subsidiary = subsidiary;
        this.parent = parent;
    }

    public OrganizationStructureType getType() {
        return type;
    }

    public Organization getParent() {
        return parent;
    }

    public Organization getSubsidiary() {
        return subsidiary;
    }
}
