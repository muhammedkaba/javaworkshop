package oopOdev3;


public class Player {
	private int id;
	private String nationalId;
	private String firstName;
	private String lastName;
	private int birthYear;
	
	public Player() {
		
	}

	public Player(int id, String nationalId, String firstName, String lastName, int birthYear) {
		super();
		this.id = id;
		this.nationalId = nationalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
}
