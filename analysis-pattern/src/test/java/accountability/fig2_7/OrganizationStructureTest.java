package accountability.fig2_7;

import org.junit.jupiter.api.Test;

import static accountability.fig2_7.OrganizationStructureType.LINE_MANAGEMENT;
import static accountability.fig2_7.OrganizationStructureType.PRODUCT_SUPPORT;
import static accountability.fig2_7.OrganizationStructureType.SALES_ORGANIZATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrganizationStructureTest {
    /// {{{ copied from fig2_7
    @Test
    public void should_2176_cappuccino_maker_in_Boston_report_to_Boston_sales_office() {
        Organization boston2176ServiceTeam = new ServiceTeam("Boston 2176");
        Organization bostonSalesOffice = new SalesOffice("Boston");
        OrganizationStructure structure = new OrganizationStructure(
                LINE_MANAGEMENT, boston2176ServiceTeam, bostonSalesOffice);
        assertThat(structure.getType()).isEqualTo(LINE_MANAGEMENT);
        assertThat(structure.getSubsidiary()).isEqualTo(boston2176ServiceTeam);
        assertThat(structure.getParent()).isEqualTo(bostonSalesOffice);
    }

    @Test
    public void should_2176_cappuccino_maker_in_Boston_report_to_2170_family_service_center() {
        Organization boston2176ServiceTeam = new ServiceTeam("Boston 2176");
        Organization family2170ServiceCenter = new ServiceCenter("2170 family");
        OrganizationStructure structure = new OrganizationStructure(
                PRODUCT_SUPPORT, boston2176ServiceTeam, family2170ServiceCenter);
        assertThat(structure.getType()).isEqualTo(PRODUCT_SUPPORT);
        assertThat(structure.getSubsidiary()).isEqualTo(boston2176ServiceTeam);
        assertThat(structure.getParent()).isEqualTo(family2170ServiceCenter);
    }
    ///}}}
    
    @Test
    public void should_not_allow_sales_office_report_to_division_given_structure_type_sales_organization() {
        Organization salesOffice = new SalesOffice("SalesOffice-A");
        Organization division = new Division("Division-B");
        assertThatThrownBy(() -> new OrganizationStructure(SALES_ORGANIZATION, salesOffice, division))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not allow SalesOffice report to Division");
    }
}
