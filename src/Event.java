
public class Event {
	
	private String eventName;
	private int Attempts;
	private boolean bigBet;
	
	public Event(String eventName, int Attempts, boolean bigBet){
		this.eventName = eventName;
		this.Attempts = Attempts;
		this.bigBet = bigBet;
	}
	
	public String getEventName(){
		return eventName;
	}
	
	public int getAttempts(){
		return Attempts;
	}
	
	public boolean getBigBet(){
		return bigBet;
	}
	
	                   

}
