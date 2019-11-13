import java.util.Arrays;

// Lucas Jang
// Period 4
// Uses split method to find the filling of sandwiches
// 10/21/2019

public class Split {
	
		// Your task Part 0

		// String.split();

		// It's a method that acts on a string, <StringName>.split(<sp>);

		// Where sp is the string where the string splits

		// And it returns an array of Strings

		// Example: "I like apples!".split(" ");

		// it will split at spaces and return an array of ["I","like","apples!"]

		// Example 2: "I really like really red apples!".split("really")

		// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

		// play around with String.split!

		// What happens if you "I reallyreally likeapples".split("really") ?
		
			// String[] outputArray1 = "I like apples!".split(" ");
			// System.out.println(Arrays.toString(outputArray1));
			// String[] outputArray2 = "I really like really red apples!".split("really");
			// System.out.println(Arrays.toString(outputArray2));
			// String[] outputArray3 = "I really like really red apples!".split(" really ");
			// System.out.println(Arrays.toString(outputArray3));
			// String[] outputArray4 = "really I really like really red apples! really!".split("really");
			// System.out.println(Arrays.toString(outputArray4));
		
	
		// Your task Part 1:

		/*Write a method that take in a string like

		* "applespineapplesbreadlettucetomatobaconmayohambreadcheese"

		* describing a sandwich.

		* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

		* the sandwich and ignores what's on the outside

		* What if it's a fancy sandwich with multiple pieces of bread?

		*/

	public static String part1(String sandwich) {
		sandwich = sandwich + " "; // make it so that there is always a length of 3 if a sandwich is present
		String[] split_sandwich = sandwich.split("bread");
		String answer = "yes";
		if(sandwich.contains("bread")) {
			String ingredients = split_sandwich[1]; // prime variable, if there is only two breads then the index of ingredients will always be 1
			if (split_sandwich.length < 3 || Arrays.equals(split_sandwich, "breadbread ".split("bread"))) { // Deals with less than 2 breads and "breadbread" case
				answer = "Sorry this is not a sandwich"; // this is not a sandwich
			} else if (split_sandwich.length == 3) {
				answer = ingredients; // when there is just two breads
			} else {
				for(int i = 3; i < split_sandwich.length; i++) { // runs when there is more than two breads present
				ingredients = ingredients + "bread" + split_sandwich[i-1]; // adds the first index and then bread and then the next index to a String
				}
				answer = ingredients;
			}
		} else {
			answer = "Sorry this is not a sandwich"; // Says not a sandwich if there is not bread present in input String
		}
		return answer;
	}
	
		//Your task pt 2:

		/*Write a method that take in a string like

		* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"

		* describing a sandwich

		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

		* the sandwich and ignores what's on the outside.

		* Again, what if it's a fancy sandwich with multiple pieces of bread?

		*/
	public static String part2(String sandwich) {
		String[] split_sandwich = sandwich.split(" ");
		int breadcounter = 0;
		int[] bread_index = new int[split_sandwich.length]; // Array of index of breads
		for(int i = 0; i < split_sandwich.length; i++) {
			if(split_sandwich[i].equalsIgnoreCase("bread")) {
				bread_index[breadcounter] = i; // Adds index of each bread in array
				breadcounter++; // Total Number of breads
			}
		}
		int max = bread_index[0]; // Takes max of bread indexes
		for(int i = 0; i < bread_index.length; i++) {
			if(bread_index[i] > max) {
				max = bread_index[i];
			}
		}
		int min = bread_index[0]; // Takes min of bread indexes
		for(int i = 0; i < bread_index.length; i++) {
			if(bread_index[i] == 0) {
				bread_index[i] = max;
			}
			if(bread_index[i] < min) {
				min = bread_index[i];
			}
		}
		String ingredients = "";
		if(max == 1 && min == 0) {
			return("Sorry this is not a sandwich bud"); // Accounts for "bread bread" case
		} else if (breadcounter > 1) { 
			for(int i = min + 1; i < max; i++) {
					ingredients = ingredients + split_sandwich[i] + " ";
			}
			return(ingredients);
		} else {
			return("Sorry this is not a sandwich bud"); // Not a sandwich if there are less than 2 breads 
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(part1("breadbread"));
		System.out.println(part1("applespineapplesbreadlettucebreadtomatobreadbaconbreadmayobreadhambreadcheesemustardbread"));
		System.out.println("lettucebreadtomatobreadbaconbreadmayobreadhambreadcheesemustard");
		System.out.print(part2("hambread"));
	}

}
