// Lucas Jang
// Period 4
// Use method hourglass to create an hourglass with the size of your choie
// 10/25/2019

import java.util.*;
public class HourglassCode {
	
	// My method for print lines
	public static String print(String line, String what) { // Hehe so I don't have to write anymore print line statements until the last print
		if(line == "one") {
			System.out.print(what);
		} else if (line == "next") {
			System.out.println(what);
		}
		return("");
	}
	
	// Top Half of Hourglass
	public static String tophourglass(int x) {
		
		// First Line
		print("one","|");
		for(int i = 0; i < x; i++) {
			print("one","\"");
		}
		print("next","|"); 
		
		// Body
		int decrement = 2; // Decreases # of colons
		for(int i = 0; i < (x + 1)/2 - 1 ; i++) {
			
			// Accounts for spaces
			for(int k = 0; k < i + 1; k++) {
				print("one"," "); 
			}
			print("one","\\");
			for(int j = 0; j < x - decrement; j++) {
				print("one",":");
			}
			decrement += 2; // Updates decrease colon #
			print("next","/");
		}
		return "";
	}
	
	// Two straight lines between top and bottom half of hour glass
	public static String middle(int x) {
		
		// Adds spaces
		String spaces = "";
		for(int v = 0; v < (x + 1)/2; v++) {
			spaces += " ";
		}
		
		// Accounts for positive or negative
		if(x % 2 == 0) {
			print("next", spaces + "||");
		} else if (x % 2 == 1) {
			print("next", spaces + "|");
		}
		return "";
	}
	
	// Bottom half of Hourglass
	public static String bottomhourglass(int x) {
		
		// Body
		int increment; // Increases # of colons
		if(x % 2 == 0) {
			increment = 2;
		} else {
			increment = 1;
		}
		for(int i = (x+1)/2 - 1; i > 0 ; i--) { 
			
			// Accounts for spaces
			for(int k = 0; k < i; k++) {
				print("one"," "); 
			}
			print("one", "/");
			for(int j = 0; j < increment; j++) {
				print("one",":");
			}
			increment += 2; // Updates increase colon #
			print("next","\\");
		}	
		
		// Last Line
		print("one","|");
		for(int i = 0; i < x; i++) {
			print("one","\"");
		}
		print("one","|");
		return "";
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Well Hello There. Welcome to my Hourglass Program.");
		String answer = "yes";
		while("yes".equalsIgnoreCase(answer)) { // For some reason, doing == and != to end the while loop didn't work :(
			System.out.println("Please Tell Me How Big You Would Like Your Hourglass");
			int size = input.nextInt();
			size = Math.abs(size);
			System.out.println(tophourglass(size) + middle(size) + bottomhourglass(size));
			System.out.println("Would you like to go again? Type yes to go again or no to quit.");
			answer = input.next();
		}
		System.out.println("Thanks, come again!");
		input.close();
	}

}
