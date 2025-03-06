package irctc.app;

import java.util.Scanner;

public class TicketBookingController {

	public static void main(String[] args) {
		TicketBookingService ticketSystem = new TicketBookingService();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nRailway Booking System:");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. View Confirmed Tickets");
			System.out.println("4. View Available Tickets");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Age: ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Gender (Male/Female): ");
				String gender = scanner.nextLine();
				System.out.print("Enter Berth Preference (L/U/M): ");
				String berthPreference = scanner.nextLine();
				ticketSystem.bookTicket(name, age, gender, berthPreference);
				break;
			case 2:
				System.out.print("Enter Ticket ID to Cancel: ");
				String ticketId = scanner.nextLine();
				ticketSystem.cancelTicket(ticketId);
				break;
			case 3:
				ticketSystem.printBookedTickets();
				break;
			case 4:
				ticketSystem.printAvailableTickets();
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
