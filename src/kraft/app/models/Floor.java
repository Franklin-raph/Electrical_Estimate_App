package kraft.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Floor implements Serializable {
    private static final long serialversionUID = 50L;
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
