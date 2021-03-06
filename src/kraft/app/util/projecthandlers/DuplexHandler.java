package kraft.app.util.projecthandlers;

public class DuplexHandler {
    private boolean hasStore;
    private boolean isAllBedRoomMaster;
    private boolean hasDinningRoom;
    private int numberOfBedroomsGround;
    private int numberOfBedroomsUp;
    private static DuplexHandler instance;

    private DuplexHandler() {};

    public boolean isHasStore() {
        return hasStore;
    }

    public boolean isAllBedRoomMaster() {
        return isAllBedRoomMaster;
    }

    public boolean isHasDinningRoom() {
        return hasDinningRoom;
    }

    public int getNumberOfBedroomsGround() {
        return numberOfBedroomsGround;
    }

    public int getNumberOfBedroomsUp() {
        return numberOfBedroomsUp;
    }

    public static DuplexHandler getInstance() {
        if(instance == null)
            instance = new DuplexHandler();
        return instance;
    }
}
