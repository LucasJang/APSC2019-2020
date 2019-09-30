import java.util.*;

public class QuadraticClient {

		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to Quadratic Describer");
			System.out.println("Provide values for coefficients a, b, and c");
			String answer = "";
			while(answer != "quit") {
					System.out.println("a:");
						double a = input.nextDouble();
					System.out.println("b:");
						double b = input.nextDouble();
					System.out.println("c:");
						double c = input.nextDouble();
					System.out.println("Computing...");
					String describer = Quadratic.quadrDescriber(a,b,c);
					System.out.println(describer);
					System.out.println("Would you like to going? (Type \"quit\" to end)");
					answer = input.next();
			}
			System.out.println("Okay, thank you! Bye Bye.");
			input.close();
		}
}
