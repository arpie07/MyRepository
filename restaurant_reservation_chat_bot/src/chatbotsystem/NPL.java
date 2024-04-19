package chatbotsystem;

import java.util.Vector;

public class NPL {
	public static Vector<String> processing(String x){ //tokenization of userInputs
		Vector<String> userMessage = new Vector<>(cleaning(x));
		
		for(int i = 0; i < userMessage.size(); i++) {
			userMessage.set(i, stem(userMessage.get(i)));
		}
		
		
		return userMessage;
	}

	public static String[] split(String x) {
	    String[] y = x.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
	    return y;
	}
	
	public static Vector<String> cleaning(String x){
		Vector<String> userMessage = new Vector<>();

		for(String z : split(x)) {
				if(isAvailable(z)) {
					userMessage.add(z);	
				}
							
		}
		
		return userMessage;
	}
	
	public static String stem(String x) {
		
			
		switch(x) {
		case "reserve":
		case "reservation":
		case "book": 
		case "schedule":
			x = "reserve";
			break;
		
		case "info":
		case "inquire":
		case "information":
		case "about":
			x = "info";
			break;
			
		case "cancel":
		case "reboke":
			x = "cancel";
			break;
		default: 
			break;
		}
		
		
		
		return x;
		
	}
	
	
	public static Boolean isAvailable(String x) {
		Boolean isTrue = false;
		
		String[] listedWords = {
				"reserve", "reservation","info", "information","inquire","cancel","book","schedule", "revoke", "about"
		};
		
		for(int i = 0; i < (listedWords.length); i++) {
			if(x.equals(listedWords[i])) {
				isTrue = true;
			}
		}
		
		
		
		return isTrue;
	}
	
	
	
}
