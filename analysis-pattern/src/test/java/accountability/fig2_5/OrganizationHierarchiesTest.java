package accountability.fig2_5;

import accountability.fig2_5.sales.Division;
import accountability.fig2_5.sales.OperatingUnit;
import accountability.fig2_5.sales.Region;
import accountability.fig2_5.sales.SalesOffice;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrganizationHierarchiesTest {
    @Test
    public void organization_supertype_with_hierarchic_relationship() {
        Organization unit = new OperatingUnit();
        Organization region = new Region();
        unit.addSalesSubsidiary(region);

        Organization division = new Division();
        region.addSalesSubsidiary(division);

        Organization salesOffice = new SalesOffice();
        division.addSalesSubsidiary(salesOffice);

        assertThat(unit.getSalesSubsidiaries()).isEqualTo(ImmutableList.of(region));
        assertThat(region.getSalesSubsidiaries()).isEqualTo(ImmutableList.of(division));
        assertThat(division.getSalesSubsidiaries()).isEqualTo(ImmutableList.of(salesOffice));
    }
    
    @Test
    public void operating_unit_can_only_add_region() {
        Organization unit = new OperatingUnit();

        assertThrowException(unit, new OperatingUnit(), "Can only add Region for OperatingUnit");
        assertThrowException(unit, new Division(), "Can only add Region for OperatingUnit");
        assertThrowException(unit, new SalesOffice(), "Can only add Region for OperatingUnit");
    }

    @Test
    public void region_can_only_add_division() {
        Organization region = new Region();

        assertThrowException(region, new OperatingUnit(), "Can only add Division for Region");
        assertThrowException(region, new Region(), "Can only add Division for Region");
        assertThrowException(region, new SalesOffice(), "Can only add Division for Region");
    }

    @Test
    public void division_can_only_add_sales_office() {
        Organization division = new Division();

        assertThrowException(division, new OperatingUnit(), "Can only add SalesOffice for Division");
        assertThrowException(division, new Region(), "Can only add SalesOffice for Division");
        assertThrowException(division, new Division(), "Can only add SalesOffice for Division");
    }

    @Test
    public void sales_office_can_not_add_anything() {
        Organization salesOffice = new SalesOffice();

        assertThrowException(salesOffice, new OperatingUnit(), "Can not add anything for SalesOffice");
        assertThrowException(salesOffice, new Region(), "Can not add anything for SalesOffice");
        assertThrowException(salesOffice, new Division(), "Can not add anything for SalesOffice");
        assertThrowException(salesOffice, new SalesOffice(), "Can not add anything for SalesOffice");
    }

    private void assertThrowException(Organization parent, Organization subsidiary, String message) {
        assertThatThrownBy(() -> parent.addSalesSubsidiary(subsidiary))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}
