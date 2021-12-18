package accountability.fig2_6;

public class OrganizationStructure {
    private final OrganizationStructureType type;
    private final Organization subsidiary;
    private final Organization parent;

    public OrganizationStructure(OrganizationStructureType type, Organization subsidiary, Organization parent) {
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
