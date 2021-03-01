package kraft.app.util.projecthandlers;

public class BungalowHandler {
    private int numberOfBedrooms;
    private boolean hasStore;
    private boolean isAllBedRoomMaster;
    private boolean hasDinningRoom;
    private static BungalowHandler instance;

    private BungalowHandler() {
    }

    public static BungalowHandler getInstance() {
        if (instance == null)
            instance = new BungalowHandler();
        return instance;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public boolean isHasStore() {
        return hasStore;
    }

    public void setHasStore(boolean hasStore) {
        this.hasStore = hasStore;
    }

    public boolean isAllBedRoomMaster() {
        return isAllBedRoomMaster;
    }

    public void setAllBedRoomMaster(boolean allBedRoomMaster) {
        isAllBedRoomMaster = allBedRoomMaster;
    }

    public boolean isHasDinningRoom() {
        return hasDinningRoom;
    }

    public void setHasDinningRoom(boolean hasDinningRoom) {
        this.hasDinningRoom = hasDinningRoom;
    }
}
