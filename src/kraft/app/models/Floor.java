package kraft.app.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorLevel;
    private List<Room> rooms;

    public Floor(int floorLevel) {
        this.floorLevel = floorLevel;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
