// Lucas Jang
// August 29, 2019
// Period 4
// Group of methods that perform math calculations aka library

public class Calculate {
// PART 1
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
		answer = (number1 + number2)/2.0;
		return answer;
	}
	public static double average(double number1, double number2, double number3) { // a call to average returns the average of the three values passed, accepts three doubles and returns a double
		double answer = 0;
		answer = (number1 + number2 + number3)/3.0;
		return answer;
	}
	public static double toDegrees(double number) { // a call to toDegrees returns the conversion to degrees from radians passed, accepts and returns a double
		double answer = 0;
		answer = number * (180/3.14159);
		return answer;
	}
	public static double toRadians(double number ) { // a call to toRadians return the conversion to radians from degrees passed, accepts a double and returns a double
		double answer = 0;
		answer = number * (3.14159/180);
		return answer;
	}
	public static double discriminant(double a, double b, double c) { // a call to discriminant returns the discriminant of the three coefficients of a quadratic passed, accepts three doubles and returns one double
		double answer = 0;
		answer = (b * b) - (4 * a * c);
		return answer;
	}
	public static String toImproperFrac(int a, int b, int c) { // a call to toImproperFrac returns an improper fraction converted from a mixed number, accepts three integers and returns a string
		String answer = "0";
		answer = (a * c) + b + "/" + c;
		return answer;
	}
	public static String toMixedNum(int a, int b) { // a call to toMixedNum returns a mixed number converted from an improper fraction, accepts two integers and returns a string
		String answer ="0";
		answer = (a/b) + "_" + (a%b) + "/" + 2;
		return answer;
	}
	public static String foil(int a, int b, int c, int d, String e) { // a call to foil returns a quadratic equation from a binomial, accepts four integers and one string and returns a string
		String answer = "0";
		answer = a*c + e + "^2" + " + " + (a*d + b*c) + e + " + " + (b*d);
		return answer;
	}
// PART 2
	public static boolean isDivisibleBy(int a, int b) { // a call to isDivisibleBy determines whether or not one integer is divisible by another, accepts two integers and returns a boolean
		boolean answer = true;
		answer = (a%b) == 0;
		return answer;
	}
	public static double absValue(double number) { // a call to absVal returns the absolute value of the number passed, accepts and returns and double
		double answer = 0;
		answer = number*((2*number+1)%2);
		return answer;
	}
	// public static double absValue(double number) { // a call to absVal returns the absolute value of the number passed, accepts and returns and double
	// 		double answer = 0;
	//		if(number < 0) {
	//      	answer = number * -1;
	//      } else {
	//			answer = number;
	//		}
	//		return answer;
	// }
	public static double max(double a, double b) { // a call to max returns the larger of the two passed, accepts two doubles and returns a double
		double answer = 0;
		if(a>b) {
			answer = a;
		} else {
			answer = b;
		}
		return answer;
	}
	public static double max(double a, double b, double c) { // a call to max returns the larger of the three passed, accepts three doubles and returns a double
		double answer = 0;
		if(a>b) {
			answer = a;
		} else {
			answer = b;
		}
		if(c>answer) {
			answer = c;
		}
		return answer;
	}
	public static double min(int a, int b) { // a call to min returns the samller of the two passed, accepts two integers and returns an integer
		if(a<b) { 
			return a;
		} else {
			return b;
		}
	}
	public static double round2(double a) { // a call to round2 returns the number correctly rounded to two decimal places, accepts and returns a double
		a = a * 100;
		a = (int)a;
		a = (double)a/100;
		return(a);
	}
// PART 3
	public static double exponent(double a, int b) { // a call to exponent returns the first number to the second number's power, accepts a double and an integer and returns a double
		int i = 1;
		double multiplier = a;
		while(i != b) {
			a = a * multiplier;
			i++;
		}
		return a;
	}
	public static int factorial(int a) { // a call to factorial returns the factorial of the value passed, accepts and returns an integer
		int i = 1;
		int n = 1;
		while(i != a) {
			i++;
			n = i * n;
		}
		return n;
	}
	public static boolean isPrime(int a) { // a call to isPrime determines whether or not the number passed is prime, accepts an integer and returns a boolean
		int i = 2;
		if(Calculate.isDivisibleBy(a,i)==false) {
			i++;	
			return true;
		} else {
			return false;
		}
	}
	public static int gfc(int a, int b) { // a call to gfc returns the greatest common factor of two integers passed, accepts two integers and returns one integer
		int i = 2;
		while(i<Calculate.max(a,b)) {
			Calculate.isDivisibleBy(a,i)!=Calculate.isDivisibleBy(b,i);
		}

	}
}


