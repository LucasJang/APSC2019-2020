// Lucas Jang
// August 29, 2019
// Period 4
// Group of methods that perform math calculations aka library

public class Calculate {
	public static int square(int number) { // a call to square returns the square of the value passed, accepts and returns integer
		int answer = 0;
		answer = number * number;
		return answer;
	}
	public static int cube(int number) { // a call to cube returns the cube of the value passed, accepts and returns integer
		int answer = 0;
		answer = number * number * number;
		return answer;
	}
	public static double average(double number1, double number2) { // a call to average returns the average of the two values passed, accepts two doubles and returns a double
		double answer = 0;
		answer = (number1 * number2)/2;
		return answer;
	}
	public static double average(double number1, double number2, double number3) { // a call to average returns the average of the three values passed, accepts three doubles and returns a double
		double answer = 0;
		answer = (number1 * number2 * number3)/3;
		return answer;
	}
	public static double toDegrees(double number) { // a call to toDegrees returns the conversion to degrees from radians passed, accepts and returns a double
		double answer = 0;
		answer = number * (180/3.14159);
		return answer;
	}
	public static double discriminant(double a, double b, double c) { // a call to discriminant returns the discriminant of the three coefficients of a quadratic passed, accepts three doubles and returns one double
		double answer = 0;
		answer = (b * b) - (4 * a * c);
		return answer;
	}
	public static String toImproperFrac(int a, int b, int c) { // a call to toImproperFrac returns an improper fraction converted from a mixed number, accepts three integers and returns a string
		String answer = "0";
		answer = "(a * c)+b \" c";
		return(answer);
	}
	public static String toMixedNum(int a, int b) {
		String = answer;
		answer = "(a/b)_("
	}
}
