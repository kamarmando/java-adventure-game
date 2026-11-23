import java.util.Random;

public class Ticket {
    private int ticketNumber;
    private String purchaserName;
    private int confirmationCode;

    public Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
        this.purchaserName = "";
        this.confirmationCode = 0;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public int getConfirmationCode() {
        return confirmationCode;
    }

    public void sellTicket(String name) {
        Random random = new Random();
        purchaserName = name;
        confirmationCode = random.nextInt(900000) + 100000;
    }

    public boolean isSold() {
        return !purchaserName.equals("") && confirmationCode != 0;
    }
}
