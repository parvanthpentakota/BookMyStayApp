import java.util.Set;

/**
 * Validates booking inputs and system state
 */
public class BookingValidator {

    private static final Set<String> VALID_ROOMS =
            Set.of("Single Room", "Double Room", "Suite Room");

    public static void validate(String guestName, String roomType, int available)
            throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room type
        if (!VALID_ROOMS.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        // Validate availability
        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for: " + roomType);
        }
    }
}