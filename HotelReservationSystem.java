import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();
        int bookingIdCounter = 1;

        
        rooms.add(new Room(1, "Single", true));
        rooms.add(new Room(2, "Double", true));
        rooms.add(new Room(3, "Suite", true));
        rooms.add(new Room(4, "Single", true));
        rooms.add(new Room(5, "Double", true));
        rooms.add(new Room(6, "Suite", true));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search rooms");
            System.out.println("2. Make reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter room category: ");
                    String category = sc.next();
                    System.out.println("Available rooms in " + category + " category:");
                    for (Room room : rooms) {
                        if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                            System.out.println("Room Number: " + room.getRoomNumber());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter room category: ");
                    category = sc.next();
                    Room room = null;
                    for (Room r : rooms) {
                        if (r.getCategory().equalsIgnoreCase(category) && r.isAvailable()) {
                            room = r;
                            break;
                        }
                    }

                    if (room!= null) {
                        room.setAvailable(false);
                        System.out.print("Enter guest name: ");
                        String guestName = sc.next();
                        System.out.print("Enter payment: ");
                        double payment = sc.nextDouble();
                        Booking booking = new Booking(bookingIdCounter++, room, guestName, payment);
                        bookings.add(booking);
                        System.out.println("Reservation successful. Booking ID: " + booking.getBookingId());
                    } else {
                        System.out.println("No rooms available in " + category + " category.");
                    }
                    break;
                case 3:
                    System.out.print("Enter booking ID: ");
                    int bookingId = sc.nextInt();
                    boolean found = false;
                    for (Booking booking : bookings) {
                        if (booking.getBookingId() == bookingId) {
                            System.out.println("Booking ID: " + booking.getBookingId());
                            System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
                            System.out.println("Guest Name: " + booking.getGuestName());
                            System.out.println("Payment: " + booking.getPayment());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No booking found with ID " + bookingId);
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    static class Room {
        public int roomNumber;
        public String category;
        public boolean isAvailable;

        public Room(int roomNumber, String category, boolean isAvailable) {
            this.roomNumber = roomNumber;
            this.category = category;
            this.isAvailable = isAvailable;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public String getCategory() {
            return category;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }
    }

    static class Booking {
        public int bookingId;
        public Room room;
        public String guestName;
        public double payment;

        public Booking(int bookingId, Room room, String guestName, double payment) {
            this.bookingId = bookingId;
            this.room = room;
            this.guestName = guestName;
            this.payment = payment;
        }

        public int getBookingId() {
            return bookingId;
        }

        public Room getRoom() {
            return room;
        }

        public String getGuestName() {
            return guestName;
        }

        public double getPayment() {
            return payment;
        }
    }
}
