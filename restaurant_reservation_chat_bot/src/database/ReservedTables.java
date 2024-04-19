package database;

import java.util.Vector;

public class ReservedTables {

	static int reservationNumber;
	static int vipLimit = 5;
	static int ordinaryLimit = 20;
	static int currentVipIndex = 0;
	static int currentOrdinaryIndex = 0;
	
	String tableClass;
	String guestName;
	int numPeople;
	String month;
	int day;
	int year;
	int time;
	int index;
	
	
	
	
	public ReservedTables(String guestName, int numPeople, String month, int day, int year, int time, int index) {
		this.numPeople = numPeople;
		this.month = month;
		this.day = day;
		this.year = year;
		this.time = time;
		this.index = index;
	}
	
	public static void initial(Vector<ReservedTables>[] table, int k) {
		
		for(int i = 0; i < k; i++) {
			table[i] = new Vector<>();
			if(i == 0) {
				table[i].add(new ReservedTables("Arjay Pielago",3,"August",7,2024,7,0));
				currentOrdinaryIndex++;
				table[i].add(new ReservedTables("John Lester Gonzaga",3,"April",24,2024,7,1));
				currentOrdinaryIndex++;
			} else {
				table[i].add(new ReservedTables("Angelica Abad",3,"May",15,2024,7,0));
				currentVipIndex++;
			}
		}
	}
	
	public static void book(Vector<ReservedTables>[] table, int j, String guestName, int numPeople, String month, int day, int year, int time, int index) {

		ReservedTables newReservation = new ReservedTables(guestName, numPeople, month, day, year, time, index);
		
		table[j].add(newReservation);
		if(j == 0) {
			currentOrdinaryIndex++;
		} else {
			currentVipIndex++;
		}
	}
	
}
