package kraft.app.models;

import kraft.app.models.enums.Fitting;
import kraft.app.models.enums.Rooms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private static final long serialversionUID = 10L;
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
