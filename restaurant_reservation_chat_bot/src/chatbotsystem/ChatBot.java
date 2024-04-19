package chatbotsystem;

import java.util.*;

import database.AI;
import database.ReservedTables;




public class ChatBot {
	
	static int arraySize = 2; //creating two table class
	
	
	public static Vector<ReservedTables> table0 = new Vector<>();
	public static Vector<ReservedTables> table1 = new Vector<>();
	
	
	public static void main(String[] args) {
		

		//Only accepts English language as inputs
		System.out.println("RRCB: \nWelcome to (Restaurant Name) Restaurant/Kitchenete, Customer! I am RRCB, short for Restaurant Reservation Chat Bot.");
		
		
		chat();	
		
		System.out.println("RRCB: Thank you for inquiring for (Restaurant Name) Restaurant/Kitchenete!\n\n");
	}

	public static void chat() {
		
		ReservedTables.initial0(table0);
		ReservedTables.initial1(table1);
		
		String userInput;
	
		Scanner input = new Scanner(System.in);
		
		do {
			
			System.out.println("\nRRCB: "
					+"\nYou can make ask about the restaurant, reserve a table, or cancel a reservation. "
					+ "Or enter 'exit' to end the chat."
					+ "\nHow may I help you?\n");
			
			
			System.out.println("User: ");
			userInput = input.nextLine();
			System.out.println("");
			
			userInput = userInput.toLowerCase(Locale.US);
			
			if(!userInput.equals("exit")) {
				aiResponse(userInput);
				
			}
		
		}while(!userInput.equals("exit"));
		
		
		
		input.close();
	}

	public static void aiResponse(String x) {
		
		AI.templates(NPL.processing(x));

	}
	
	
}
