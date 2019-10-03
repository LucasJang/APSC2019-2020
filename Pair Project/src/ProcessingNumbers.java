import java.util.*;

public class ProcessingNumbers {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int next = 0;
		int sumEven = 0;
		System.out.println("How many numbers are in your list?");
		int totalNum = input.nextInt();
		System.out.println("Please print your first integer");
		int max = input.nextInt();
		int min = max;
		int maxEven = max;
		for(int i = 1 ; i < totalNum ; i++) {
			System.out.println("Please print your next integer");
			next = input.nextInt();
			if(next>max) {
				max = next;
			} else if(next<min) {
				min = next;
			}
			if(next % 2 == 0) {
				sumEven = sumEven + next;
				if(next > min) {
					maxEven = next;
				}
			}
		}
		System.out.println("Smallest: " + min);
		System.out.println("Largest: " + max);
		System.out.println("Sum of Even Numbers: " + sumEven);
		if(maxEven % 2 != 0) {
			System.out.println("No even number inputed");
		} else {
			System.out.println("Largest Even Number: " + maxEven);
		}
		input.close();
	}
}
