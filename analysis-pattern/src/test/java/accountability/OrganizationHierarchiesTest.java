package accountability;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganizationHierarchiesTest {
    @Test
    public void organization_structure_with_explicit_levels() {
        OperatingUnit unit = new OperatingUnit();
        Region region = new Region();
        unit.addRegion(region);

        Division division = new Division();
        region.addDivision(division);

        SalesOffice salesOffice = new SalesOffice();
        division.addSalesOffice(salesOffice);

        assertThat(unit.getRegions()).isEqualTo(ImmutableList.of(region));
        assertThat(region.getDivisions()).isEqualTo(ImmutableList.of(division));
        assertThat(division.getSalesOffices()).isEqualTo(ImmutableList.of(salesOffice));
    }
}
