import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static String showName = "";

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== TICKET SELLING SYSTEM =====");
            System.out.println("1. Manage Shows");
            System.out.println("2. Sell Tickets");
            System.out.println("3. Print Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    manageShows();
                    break;
                case 2:
                    sellTickets();
                    break;
                case 3:
                    printReport();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);
    }

    public static void manageShows() {
        System.out.print("Enter show name: ");
        showName = input.nextLine();

        System.out.print("How many tickets? ");
        int number = input.nextInt();
        input.nextLine();

        tickets.clear();

        for (int i = 1; i <= number; i++) {
            tickets.add(new Ticket(i));
        }

        System.out.println("Show created successfully!");
    }

    public static void sellTickets() {
        if (tickets.isEmpty()) {
            System.out.println("Create a show first.");
            return;
        }

        System.out.print("Enter ticket number: ");
        int number = input.nextInt();
        input.nextLine();

        if (number < 1 || number > tickets.size()) {
            System.out.println("Invalid ticket number.");
            return;
        }

        Ticket ticket = tickets.get(number - 1);

        if (ticket.isSold()) {
            System.out.println("Already sold! Choose another ticket.");
            return;
        }

        System.out.print("Enter purchaser name: ");
        String name = input.nextLine();

        ticket.sellTicket(name);

        System.out.println("Ticket sold!");
        System.out.println("Confirmation code: " + ticket.getConfirmationCode());
    }

    public static void printReport() {
        if (tickets.isEmpty()) {
            System.out.println("No shows created.");
            return;
        }

        System.out.println("\n===== SHOW REPORT =====");
        System.out.println("Show: " + showName);

        for (Ticket ticket : tickets) {
            System.out.println("----------------------");
            System.out.println("Ticket #: " + ticket.getTicketNumber());
            System.out.println("Purchaser: " +
                (ticket.isSold() ? ticket.getPurchaserName() : "Not sold"));
            System.out.println("Confirmation Code: " + ticket.getConfirmationCode());
        }
    }
}
