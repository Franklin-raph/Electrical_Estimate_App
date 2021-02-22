package kraft.app.models;

import kraft.app.models.enums.Fitting;
import kraft.app.models.enums.Rooms;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private Rooms roomType;
    private List<Fitting> fittings;

    public Room(Rooms roomType) {
        this.roomType = roomType;
        this.fittings = new ArrayList<>();
    }

    public void addFitting (Fitting fitting) {
        fittings.add(fitting);
    }

    public Rooms getRoomType() {
        return roomType;
    }

    public List<Fitting> getFittings() {
        return fittings;
    }
}
