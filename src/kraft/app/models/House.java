package kraft.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class House implements Serializable {
    private static final long serialversionUID = 100L;
    private int numberOfFloors;
    private List<Floor> floors;

    public House(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.floors = new ArrayList<>(numberOfFloors);
    }

    public void addFloor(Floor floor) {
        if (numberOfFloors < floors.size())
            floors.add(floor);
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
