import java.io.Serializable;

public class Reservation implements Serializable {

    private String guestName;
    private String roomType;
    private String roomId;

    // ✅ Constructor with roomId (UC8+)
    public Reservation(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    // ✅ Constructor WITHOUT roomId (UC5, UC6, UC11)
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = "Not Assigned";
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public String getRoomId() { return roomId; }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void display() {
        System.out.println("Guest: " + guestName +
                " | Room: " + roomType +
                " | Room ID: " + roomId);
    }
}