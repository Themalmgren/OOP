
public class Result {
	
	private int number;
	private String nameOfEvent;
	private double result;
	//private int currentTry;
	
	
	
	
	public Result(int number, String nameOfEvent, double result){
		this.result = result;
		this.nameOfEvent = nameOfEvent;
		this.number = number;
		//this.currentTry = currentTry;
		
	}

	public int getParticipantNumber(){
		return number;
	}
	public String getNameOfEvent(){
		return nameOfEvent;
	}
	public double getResult(){
		return result;
	}
	public void setResult(double newResult){
		
	
	}
	
	
//	public int getCurrentTry(){
//		return currentTry;
//	}
	


}
