package Game.Room;

import java.util.ArrayList;

public class RoomSet {
    private ArrayList<Room> rooms = new ArrayList<>();

    public RoomSet() {
    }

    public RoomSet(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

}
