package accountability.fig2_7;

public enum OrganizationStructureType {
    PRODUCT_SUPPORT, SALES_ORGANIZATION {
        @Override
        public boolean isAllowed(Class<?> subsidiary, Class<?> parent) {
            // 先写死，应该用一个List保存层次关系
            if (subsidiary == SalesOffice.class && parent == Division.class) {
                return false;
            }
            return super.isAllowed(subsidiary, parent);
        }
    }, LINE_MANAGEMENT;

    public boolean isAllowed(Class<?> subsidiary, Class<?> parent) {
        return true;
    }
}
