package irctc.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class TicketBookingService{

	private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "U", "M")); // Available confirmed
																								// berths
	private final Queue<PassengerDTO> racQueue = new LinkedList<>(); // Queue for RAC passengers
	private final Queue<PassengerDTO> waitingListQueue = new LinkedList<>(); // Queue for waiting list passengers
	private final List<PassengerDTO> confirmedPassengers = new ArrayList<>(); // List of confirmed passengers
	private int ticketCounter = 1; // Counter for generating unique ticket IDs
	// Booking tickets

	public void bookTicket(String name, int age, String gender, String berthPreference){
		String ticketId = "T" + ticketCounter++; // Generate unique ticket ID
		PassengerDTO passenger;
		// Check for available confirmed tickets
		if (!availableBerths.isEmpty()) {
			String allocatedBerth = allocateBerth(age, gender, berthPreference);
			passenger = new PassengerDTO(name, age, gender, berthPreference, allocatedBerth, ticketId);
			confirmedPassengers.add(passenger); // Add to confirmed list
			availableBerths.remove(allocatedBerth); // Remove allocated berth
			System.out.println("Ticket confirmed: " + passenger);
		}
		// Check for RAC availability
		else if (racQueue.size() < 1) {
			passenger = new PassengerDTO(name, age, gender, berthPreference, "RAC", ticketId);
			racQueue.offer(passenger); // Add to RAC queue
			System.out.println("Ticket in RAC: " + passenger);
		}
		// Check for Waiting List availability
		else if (waitingListQueue.size() < 1) {
			passenger = new PassengerDTO(name, age, gender, berthPreference, "Waiting List", ticketId);
			waitingListQueue.offer(passenger); // Add to Waiting List
			System.out.println("Ticket in Waiting List: " + passenger);
		}
		// No tickets available
		else {
			System.out.println("No tickets available");
		}
	}

	// Allocating berth based on conditions
	private String allocateBerth(int age, String gender, String preference){
		if (age > 60 || gender.equalsIgnoreCase("female") && availableBerths.contains("L")) {
			return "L"; // Prioritize lower berth
		}
		if (availableBerths.contains(preference)) {
			return preference; // Allocate preferred berth
		}
		return availableBerths.get(0); // Allocate first available berth
	}

	// Canceling tickets
	public void cancelTicket(String ticketId){
		Optional<PassengerDTO> passengerOpt = confirmedPassengers.stream().filter(p -> p.ticketId.equals(ticketId))
				.findFirst();
		if (passengerOpt.isPresent()) {
			PassengerDTO passenger = passengerOpt.get();
			confirmedPassengers.remove(passenger);
			availableBerths.add(passenger.allottedBerth);
			// Move RAC to confirmed
			if (!racQueue.isEmpty()) {
				PassengerDTO racPassenger = racQueue.poll();
				String allocatedBerth = allocateBerth(racPassenger.age, racPassenger.gender,
						racPassenger.berthPreference);
				racPassenger.allottedBerth = allocatedBerth;
				confirmedPassengers.add(racPassenger);
				availableBerths.remove(allocatedBerth);
				System.out.println("RAC ticket moved to confirmed: " + racPassenger);
			}
			// Move Waiting List to RAC
			if (!waitingListQueue.isEmpty()) {
				PassengerDTO waitingPassenger = waitingListQueue.poll();
				racQueue.offer(waitingPassenger);
				waitingPassenger.allottedBerth = "RAC";
				System.out.println("Waiting list ticket moved to RAC: " + waitingPassenger);
			}
			System.out.println("Ticket cancelled successfully for ID: " + ticketId);
		} else {
			System.out.println("No ticket found with ID: " + ticketId);
		}
	}

	// Printing confirmed tickets
	public void printBookedTickets() {
		if (confirmedPassengers.isEmpty()) {
			System.out.println("No confirmed tickets.");
		} else {
			System.out.println("Confirmed Tickets:");
			for (PassengerDTO passenger : confirmedPassengers) {
				System.out.println(passenger);
			}
		}
	}

	// Printing available tickets
	public void printAvailableTickets() {
		System.out.println("Available Berths: " + availableBerths.size());
		System.out.println("Available RAC Tickets: " + (1 - racQueue.size()));
		System.out.println("Available Waiting List Tickets: " + (1 - waitingListQueue.size()));
	}

}
