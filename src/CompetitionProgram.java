import java.util.Scanner;
import java.util.ArrayList;

public class CompetitionProgram {

	Scanner keyboard = new Scanner(System.in);

	ArrayList<Participant> participantList = new ArrayList<Participant>();
	ArrayList<Result> resultList = new ArrayList<Result>();
	ArrayList<Event> eventList = new ArrayList<Event>();

	private int startNumber = 99;
	private String nameOfParticipant;
	private String nameOfEvent;
	private String nameFromNumber;

	public String inputText(String prompt) {
		String input;
		String output;

		System.out.print(prompt);
		input = keyboard.nextLine().toLowerCase().trim();
		while (input.trim().length() < 1) {
			System.out.println("Names can't be empty!");
			System.out.print(prompt);
			input = keyboard.nextLine().toLowerCase().trim();
		}

		output = input.substring(0, 1).toUpperCase() + input.substring(1);
		return output;
	}

	public int inputNumber(String prompt) {

		System.out.print(prompt);
		int intNum = keyboard.nextInt();
		keyboard.nextLine();
		return intNum;
	}

	public double inputDecimal(String prompt) {
		System.out.print(prompt);
		double doubleNum = keyboard.nextDouble();
		keyboard.nextLine();
		return doubleNum;

	}

	public boolean convertToBoolean(String answer) {

		boolean biggerIsBetter;

		while (true) {

			if (answer.equalsIgnoreCase("y") || (answer.equalsIgnoreCase("yes"))) {
				biggerIsBetter = true;
				break;
			} else if (answer.equalsIgnoreCase("n") || (answer.equalsIgnoreCase("no"))) {
				biggerIsBetter = false;
				break;
			} else {
				answer = inputText("Wrong commando! Bigger better? (Y/N): ");

			}

		}
		return biggerIsBetter;
	}

	private String getNameFromNumber(int number) {

		for (int i = 0; i < participantList.size(); i++) {
			if (participantList.get(i).getStartNumber() == number) {
				nameOfParticipant = participantList.get(i).getFullName();
			} else {
				System.out.println("No participant with" + number + " exists");
			}

		}

		return nameOfParticipant;
	}

	private void addEvent() {

		String eventName = inputText("Event name: ");
		int x = 0;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventName.equals(eventList.get(i).getEventName())) {
				x = 1;
				System.out.println(eventName + " has already been added");
			}
		}

		if (x == 0) {
			int numberOfAttempts = inputNumber("Attempts allowed: ");
			while (numberOfAttempts <= 0) {
				numberOfAttempts = inputNumber("Must be larger than zero! Try again: ");
			}
			String biggerBetter = inputText("Bigger better? (Y/N): ");
			boolean biggerIsBetter = convertToBoolean(biggerBetter);

			eventList.add(new Event(eventName, numberOfAttempts, biggerIsBetter));
			System.out.println(eventName + " added");

		}

	}

	public void addParticipant() {
		String name = inputText("First name: ");
		String lastName = inputText("Last name: ");
		String team = inputText("Team: ");
		startNumber++;

		participantList.add(new Participant(name, lastName, team, startNumber));

		System.out.printf("%s %s from %s with number %d added", name, lastName, team, startNumber);
		System.out.println("");

	}

	private void removeParticipant() {
		startNumber = inputNumber("Number: ");
		for (int i = 0; i < participantList.size(); i++) {
			if (participantList.get(i).getStartNumber() == startNumber) {
				System.out.println(participantList.get(i).getFullName() + " from " + participantList.get(i).getTeam()
						+ " with number " + participantList.get(i).getStartNumber() + " removed");
				participantList.remove(i);

			} else {
				System.out.println("No participant with number " + startNumber + " exists");
			}

		}

	}

	private void addResult() {

		int number = inputNumber("Number: ");
		nameOfParticipant = getNameFromNumber(number);

		String eventName = inputText("Event: ");

		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getEventName().equals(eventName)) {
				nameOfEvent = eventList.get(i).getEventName();

				System.out.print("Result for " + nameOfParticipant + " in " + nameOfEvent + ": ");
				double result = inputDecimal("");
				resultList.add(new Result(number, nameOfEvent, result));

			}
		}

	}

	private void listParticipant() {

		int listNumber = inputNumber("Number: ");
		String name = getNameFromNumber(listNumber);

		for (int i = 0; i < resultList.size(); i++) {
			if (resultList.get(i).getParticipantNumber() == listNumber) {
				if (eventList.get(i).getEventName().equals(resultList.get(i).getNameOfEvent())) {
					System.out.print("Results for " + name + " in " + resultList.get(i).getNameOfEvent() + " ");
					for (i = 0; i <= 2; i++) {
						System.out.print(resultList.get(i).getResult() + ", ");

					}
					
				}

			}

		}
		System.out.println("");
	}

	private void ResultListForEvent(String command) {
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getEventName().equals(command)) {
				System.out.println(resultList.get(i).getResult());

			} else {
				System.out.println("Unknown command");
			}
		}
	}

	private void listAllTeams() {

	}

	private void printMessage() {

	}

	private void removeAllData() {

	}

	private void exitProgram() {

	}

	private void listResults() {
		System.out.println("bajs");
	}

	private String handleCommand(String command) {

		switch (command) {

		case "Add event":
			addEvent();
			break;
		case "Add participant":
			addParticipant();
			break;
		case "Remove participant":
			removeParticipant();
			break;
		case "Add result":
			addResult();
			break;
		case "Participant":
			listParticipant();
			break;
		case "Teams":
			listAllTeams();
		case "Message":
			printMessage();
			break;
		case "Reinitialize":
			removeAllData();
			break;
		case "Exit":
			exitProgram();
			break;
		default:
			ResultListForEvent(command);
			break;

		}
		return command;

	}

	private void run() {
		while (true) {

			String command = inputText("Command> ");
			handleCommand(command);

		}
	}

	public static void main(String[] args) {

		CompetitionProgram program = new CompetitionProgram();
		program.run();

	}

}
