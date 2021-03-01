package kraft.app.util.projecthandlers;

import kraft.app.models.enums.StairCase;

public class ApartmentHandler {
    private int numberOfFloor;
    private int numberOfApartmentPerFloor;
    private StairCase stairCase;
    private int numberOfBedrooms;
    private boolean hasStore;
    private boolean isAllBedRoomMaster;
    private boolean hasDinningRoom;
    private static ApartmentHandler instance;

    private ApartmentHandler() {}

    public static ApartmentHandler getInstance() {
        if (instance == null)
            instance = new ApartmentHandler();
        return instance;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public int getNumberOfApartmentPerFloor() {
        return numberOfApartmentPerFloor;
    }

    public void setNumberOfApartmentPerFloor(int numberOfApartmentPerFloor) {
        this.numberOfApartmentPerFloor = numberOfApartmentPerFloor;
    }

    public StairCase getStairCase() {
        return stairCase;
    }

    public void setStairCase(StairCase stairCase) {
        this.stairCase = stairCase;
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

    public static void setInstance(ApartmentHandler instance) {
        ApartmentHandler.instance = instance;
    }
}
