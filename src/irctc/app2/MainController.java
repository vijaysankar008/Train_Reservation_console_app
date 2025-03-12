package irctc.app2;


import java.util.Scanner;

public class MainController {
	static Scanner userInput = new Scanner(System.in);
	static PassengerDto passengerDto;

	public static void main(String[] a) {
		while(true) {
		System.out.println(
				"*******Welcome to ticket booking app********\n1.Booking\n2.Cancel\n3.Print Booked Ticket\n4.Print Available Ticket");
		System.out.println("Please select any one option.... ");
		switch (userInput.nextInt()) {
		case 1: {
				passengerDto=new PassengerDto(1, "Vijay", "26","Male","L", null, null);
				System.out.println(TicketService.bookTicket(passengerDto)); 
				
		}
		case 2:
		case 3:{
				System.out.println(TicketService.confirmTicket);
				break;
		}
		}
		}
	}
}
