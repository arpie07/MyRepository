package database;

import java.util.*;

import chatbotsystem.NPL;
import chatbotsystem.ReserveNPL;
import chatbotsystem.ChatBot;



public class AI {
	
	public static void templates(Vector<String> x) { //Database for AI responses
		
		switch(key(x)) {
			case -1: cancel(); break;
			case 1: info(); break;
			case 2: reserve(); break;
			case 3: info(); reserve(); break;
			default: error(); break;
		}

	}
	
	
	public static String responses(String x) {
		String str = "";
			
			
		
		return str;
	}
	
	public static int key(Vector<String> x) {
		int num = 0;
		
		for(int i = 0; i < x.size(); i++) {
			switch(x.get(i)) {
			case "cancel": num = -1; break;
			case "info": if(num == 0||num == 2) {num +=1;} break;
			case "reserve": if(num == 0|| num == 1) {num += 2;} break;
			default: break;
			}
		}
		
		
		return num;
	}

	public static void cancel() {
		String userInput;
		
		System.out.println("RRCB: ");
		Scanner input = new Scanner(System.in);

		
		
		
		do{
			System.out.println("To cancel a reservation, please enter the name of the person who made the reservation. Or enter 'cancel to exit'. \n");
			System.out.println("User: ");
			userInput = input.nextLine();
			
			if(!userInput.equals("cancel")) {
				
				
				for(int i = 0; i < ReservedTables.currentOrdinaryIndex; i++) {
					
					if(ChatBot.table0.get(i).guestName.equals(userInput)) {
						ChatBot.table0.remove(i);
						ReservedTables.currentOrdinaryIndex--;
						System.out.println("RRCB: \nThe reservation has been removed.");
					} else {
						System.out.println("RRCB: \nThere are no reservation in the ordinary tables under that name.");
					}
				}
				
				for(int i = 0; i < ReservedTables.currentVipIndex; i++) {
					if(ChatBot.table1.get(i).guestName.equals(userInput)) {
						ChatBot.table1.remove(i);
						ReservedTables.currentVipIndex--;
						System.out.println("RRCB: \nThe reservation has been removed.");
						break;
					} else {
						System.out.println("RRCB: \nThere are no reservation in the VIP tables under that name.");
						userInput = "cancel";
					}
				}
				
			}
			

			
		}while(!userInput.equals("cancel"));
		
	}
	
	public static void info() {
		System.out.println("The name of the restaurant is " + RestaurantInformation.name + ". The most successful five star restaurant in the city.\nLocated at " 
				+ RestaurantInformation.address + ". Business hours on Weekdays are from " + RestaurantInformation.openingHour + ":00 to " + RestaurantInformation.closingHourWeekdays
				+ ":00 and on Weekends, from " + RestaurantInformation.openingHour + ":00 to " + RestaurantInformation.openHoursWeekends + ":00.\n");
	}
	
	public static void reserve() {
		String userInput;

		int j = 0;
		String guestName = "";
		int numPeople = 0;
		String month = "April";
		int day = 19;
		int year = 2024;
		int time = 0;
		int index = 0;		
		
		
		
		
		
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.println("Would you like to reserve for ordinary or VIP?\n");
			System.out.println("User: ");
			userInput = input.nextLine();
			userInput = userInput.toLowerCase(Locale.US);
			
			
			if(!userInput.equals("cancel")) {
				
				
				userInput = ReserveNPL.process(NPL.split(userInput));
				
				
				if(userInput.equals("vip")) {
						j = 1;
						index = ReservedTables.currentVipIndex;
					break;
				} else if(userInput.equals("ordinary")) {
						j = 0;
						index = ReservedTables.currentOrdinaryIndex;
					break;
				} else {
					error();
				}
			}		
			
		}while(!userInput.equals("cancel"));

		
		while(!userInput.equals("cancel")){
			System.out.println("\nRRBC: \nHow many seats would you like to reserve(enter number in arabic value. ex: 2)?\n");
			System.out.println("User: ");
			userInput = input.nextLine();
			userInput = userInput.toLowerCase(Locale.US);
			
			if(!userInput.equals("cancel")) {
				numPeople = ReserveNPL.numSeats(NPL.split(userInput));
				
				if(numPeople <= 0) {
					error();
					
				} else {
					break;
				}
			}

			
		}
		Vector<Integer> sched = new Vector<>();

		
		
		while(!userInput.equals("cancel")){
			System.out.println("\nRRBC: \nWhen would you like to schedule your reservation(Please follow the format[Month/Day/Year])?\n");
			System.out.println("User: ");
			
			userInput = input.nextLine();
			userInput = userInput.toLowerCase(Locale.US);	
		
			

			if(!userInput.equals("cancel")) {
				sched = new Vector<>();
				sched.addAll(ReserveNPL.date(NPL.split(userInput)));

				if(sched.size() != 3) {
					error();
				} else {
					if(sched.get(0) > 12 && sched.get(0) < 1) {
						System.out.println("\nRRBC: \nMonth Invalid\n");
						continue;
					} else {
						month = ReserveNPL.month(sched.get(0));
					}

					if(sched.get(1) > 31 || sched.get(1) < 1) {
						System.out.println("\nRRBC: \nDay Invalid\n");
						continue;
					} else {
						day = sched.get(1);
					}
					
					if(sched.get(2) < 2024) {
						System.out.println("\nRRBC: \nYear Invalid! You can't reserve before 2024\n");
						
					} else {
						year = sched.get(2);
						break;
						
					}
					
				
				}
							
			}

		
			}
		
		Vector<Integer> t = new Vector<>();
		
		while(!userInput.equals("cancel")){
			t = new Vector<>();
			System.out.println("\nRRBC: \nWhat time would be the reservation? (Enter 8-23 only)?\n");
			System.out.println("User: ");
			
			userInput = input.nextLine();
			userInput = userInput.toLowerCase(Locale.US);	

			
			t.addAll(ReserveNPL.date(NPL.split(userInput)));
			
			if(!userInput.equals("cancel")) {
					
					if(t.isEmpty()||t.get(0) > 23 || t.get(0) < 8) {
						System.out.println("RRBC: \nTime Schedule Invalid\n");
						
					} else {
						time = t.get(0);
						break;
					}
				}
			}
		
		
		
		while(!userInput.equals("cancel")){
			System.out.println("RRBC: \nWhom shall the reservation be named after?\n");
			System.out.println("User: ");
			userInput = input.nextLine();
			userInput = userInput.toLowerCase(Locale.US);
			
			if(!userInput.equals("cancel")) {
				guestName = userInput;
				System.out.println("RRBC: \nThank you for your Reservation!\n");
				break;
			} 

			
		}
		if(j == 0) {
			ReservedTables.book(ChatBot.table0,j, guestName, numPeople, month, day, year, time, index);
		} else {
			ReservedTables.book(ChatBot.table1,j, guestName, numPeople, month, day, year, time, index);
		}
		
		
	}
	
	public static void error() {
		System.out.println("RRCB: \nI'm sorry. I couldn't understand the request. Would you please try again?\n");
	}
}
