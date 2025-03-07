package irctc.app2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
	public static List<PassengerDto> confirmTicket=new ArrayList<>();
	public static Long upperBirth=10L,lowerBirth=10L,middleBirth=10L;
	
	public static String bookTicket(PassengerDto passengerDto) {
		if(upperBirth!=0L||middleBirth!=0L||lowerBirth!=0L) {
			if(passengerDto.getPreffredBirth()=="L"&&lowerBirth!=0L) {
				passengerDto.setTicketStatus("Ticket Confirmed");
				passengerDto.setSeatNumber(lowerBirth--+"L");
			}
			else if(passengerDto.getPreffredBirth()=="M"&&middleBirth!=0L) {
				passengerDto.setTicketStatus("Ticket Confirmed");
				passengerDto.setSeatNumber(middleBirth--+"M");
			}
			else if(passengerDto.getPreffredBirth()=="U"&&upperBirth!=0L) {
				passengerDto.setTicketStatus("Ticket Confirmed");
				passengerDto.setSeatNumber(upperBirth--+"U");
			}
			
		confirmTicket.add(passengerDto);
		return "Ticket Confirmed";
		}else
		return "Ticket Unavailable";
	}

}
