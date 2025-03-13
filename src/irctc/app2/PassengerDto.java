package irctc.app2;

public class PassengerDto {

	private int id;
	private String name;
	private String age;
	private String gender;
	private String preffredBirth;
	private String ticketStatus;
	private String seatNumber;

	public PassengerDto() {
	}

	public PassengerDto(int id, String name, String age, String gender, String preffredBirth, String ticketStatus,
			String seatNumber) {		
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.preffredBirth = preffredBirth;
		this.ticketStatus = ticketStatus;
		this.seatNumber = seatNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPreffredBirth() {
		return preffredBirth;
	}

	public void setPreffredBirth(String preffredBirth) {
		this.preffredBirth = preffredBirth;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "PassengerDto [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", preffredBirth="
				+ preffredBirth + ", ticketStatus=" + ticketStatus + ", seatNumber=" + seatNumber + "]";
	}
	
}
