import java.util.*;

public class TravelIternaryPlanner {
    public static final List<Destination> destinations = new ArrayList<>();
    public static final History history = new History();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        destinations.add(new Destination("London", "2024-07-01", "2024-08-20", "England"));
        destinations.add(new Destination("Seoul", "2024-09-06", "2024-10-15", "South Korea"));
        destinations.add(new Destination("Tokyo", "2024-11-25", "2024-12-08", "Japan"));
        destinations.add(new Destination("Toronto", "2024-12-10", "2024-12-25", "Canada"));

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.println("\n1. View Destinations");
            System.out.println("2. Add Destination");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    viewDestinations(destinations);
                    break;
                case 2:
                    addDestination(sc);
                    break;
                case 3:
                    history.viewHistory();
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void viewDestinations(List<Destination> destinations) {
        System.out.println("\n*** Destinations ***");
        for (Destination destination : destinations) {
            System.out.println(destination);
        }
        history.add("Viewed destinations");
    }

    public static void addDestination(Scanner sc) {
        System.out.println("\nEnter Destination Details:");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Start Date (YYYY-MM-DD): ");
        String startDate = sc.next();
        System.out.print("End Date (YYYY-MM-DD): ");
        String endDate = sc.next();
        System.out.print("Country: ");
        String country = sc.next();

        destinations.add(new Destination(name, startDate, endDate, country));
        System.out.println("Destination added successfully!");
        history.add("Added destination: " + name + " (" + country + ")");
    }

    public static List<Destination> getDestinations() {
        return destinations;
    }

    static class Destination {
        public String name;
        public String startDate;
        public String endDate;
        public String country;

        public Destination(String name, String startDate, String endDate, String country) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.country = country;
        }

        public String toString() {
            return "Destination: " + name +
                    ", Dates: " + startDate + " to " + endDate +
                    ", Country: " + country;
        }
    }

    static class History {
        public List<String> actions = new ArrayList<>();

        public void add(String action) {
            actions.add(action);
        }

        public void viewHistory() {
            System.out.println("\n*** History ***");
            for (String action : actions) {
                System.out.println(action);
            }
        }
    }
}
