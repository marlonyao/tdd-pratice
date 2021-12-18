package accountability.fig2_6;

import org.junit.jupiter.api.Test;

import static accountability.fig2_6.OrganizationStructureType.LINE_MANAGEMENT;
import static accountability.fig2_6.OrganizationStructureType.PRODUCT_SUPPORT;
import static org.assertj.core.api.Assertions.assertThat;

public class OrganizationStructureTest {
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
}
