package accountability;

import java.util.ArrayList;
import java.util.List;

public class OperatingUnit {
    private List<Region> regions = new ArrayList<>();

    public void addRegion(Region region) {
        regions.add(region);
    }

    public List<Region> getRegions() {
        return regions;
    }
}
