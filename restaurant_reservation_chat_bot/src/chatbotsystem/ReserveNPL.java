package chatbotsystem;

import java.util.Vector;

public class ReserveNPL {

	public static String process(String[] a) {
		Vector<String> v = new Vector<>();

		for(String z : a) {
				if(isOnList(z)) {
					v.add(z);	
				}
							
		}
		
		
		for(int i = 0; i < v.size(); i++) {
			switch(v.get(i)) {
			case "vip":
			case "important":
			case "esteemed": 
			case "esteem":
				v.set(i, "vip");
				break;
			
			case "ordinary":
			case "common":
			case "commoner":
			case "standard":
			case "regular":
				v.set(i, "ordinary");
				break;

			default: 
				break;
			}
		}
		
		String str;
		
		if(v.isEmpty()) {
			str = "empty";
			return str;
		} else{
			str = v.get(0);
			return str;
		}
		
	}
	
	
	public static Boolean isOnList(String x) {
		Boolean isTrue = false;
		
		String[] listedWords = {
		"vip","important", "esteemed", "esteem", "ordinary", "common", "commoner", "standard", "regular"
		};
		
		for(int i = 0; i < (listedWords.length); i++) {
			if(x.equals(listedWords[i])) {
				isTrue = true;
			}
		}
		
		
		
		return isTrue;
	}
	
	public static int numSeats(String[] a) {
	int k = 0;
	
	Vector<Integer> v = new Vector<>();

	for(String z : a) {
			if(isNum(z)) {
				v.add(Integer.parseInt(z));	
			}
	return v.get(0);

	}
	
	
	return k;
	}
	
	public static Boolean isNum(String x) {
		
		
	    try {
	        Integer.parseInt(x);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
		
		
		
		
	}
	
	
	public static Vector<Integer> date(String[] a) {
		Vector<Integer> v = new Vector<>();
		
		
		for(String z : a) {
				if(isNum(z)) {
					v.add(Integer.parseInt(z));	
				}
							
		}
		
	
			return v;
		
	}
	
	
public static String month(int v) {
		
		
			switch(v) {
		    case 1:
		        return "January";
		    case 2:
		    	return "February";
		    case 3:
		    	return "March";
		    case 4:
		    	return "April";
		    case 5:
		    	return "May";
		    case 6:
		    	return "June";
		    case 7:
		        return "July";
		    case 8:
		    	return "August";
		    case 9:
		    	return  "September";
		    case 10:
		    	return "October";
		    case 11:
		    	return "November";
		    case 12:
		    	return "December";
		    default:
		    	return "Invalid month";
			}
		}
	
}
