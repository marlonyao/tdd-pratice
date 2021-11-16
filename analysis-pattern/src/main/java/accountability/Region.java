package accountability;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private List<Division> divisions = new ArrayList<>();

    public void addDivision(Division division) {
        divisions.add(division);
    }

    public List<Division> getDivisions() {
        return divisions;
    }
}
