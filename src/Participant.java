
public class Participant {
	
	private String firstName;
	private String lastName;
	private String team;
	private int startNumber;
	
	
	public Participant(String firstName, String lastName, String team, int startNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		this.startNumber = startNumber;
	}
	
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getTeam(){
		return team;
	}
	
	public int getStartNumber(){
		return startNumber;
	}
	public String getFullName(){
		return firstName + " " + lastName;
	}
	
	
	
	
	

//	public String toString(){
//		return String.format("%s %s from %s with number %f added", name, lastName, team, assignStartNumber());
//		
//	}
	
	

}
