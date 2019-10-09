// Lucas Jang
// August 29, 2019
// Period 4
// Group of methods that perform math calculations aka library

public class Calculate {
// PART 1
	public static int square(int a) { // a call to square returns the square of the value passed, accepts and returns integer
		int answer = 0;
		answer = a * a;
		return answer;
	}
	public static int cube(int a) { // a call to cube returns the cube of the value passed, accepts and returns integer
		int answer = 0;
		answer = a * a * a;
		return answer;
	}
	public static double average(double a, double b) { // a call to average returns the average of the two values passed, accepts two doubles and returns a double
		double answer = 0;
		answer = (a + b)/2.0;
		return answer;
	}
	public static double average(double a, double b, double c) { // a call to average returns the average of the three values passed, accepts three doubles and returns a double
		double answer = 0;
		answer = (a + b + c)/3.0;
		return answer;
	}
	public static double toDegrees(double radians) { // a call to toDegrees returns the conversion to degrees from radians passed, accepts and returns a double
		double answer = 0;
		answer = radians * (180/3.14159);
		return answer;
	}
	public static double toRadians(double degrees) { // a call to toRadians return the conversion to radians from degrees passed, accepts a double and returns a double
		double answer = 0;
		answer = degrees * (3.14159/180);
		return answer;
	}
	public static double discriminant(double a, double b, double c) { // a call to discriminant returns the discriminant of the three coefficients of a quadratic passed, accepts three doubles and returns one double
		double answer = 0;
		answer = (b * b) - (4 * a * c);
		return answer;
	}
	public static String toImproperFrac(int whole, int num, int denom) { // a call to toImproperFrac returns an improper fraction converted from a mixed number, accepts three integers and returns a string
		String answer = "0";
		answer = (whole * denom) + num + "/" + denom;
		return answer;
	}
	public static String toMixedNum(int num, int denom) { // a call to toMixedNum returns a mixed number converted from an improper fraction, accepts two integers and returns a string
		String answer ="0";
		answer = (num/denom) + "_" + (num%denom) + "/" + denom;
		return answer;
	}
	public static String foil(int a, int b, int c, int d, String e) { // a call to foil returns a quadratic equation from a binomial, accepts four integers and one string and returns a string
		String answer = "0";
		answer = a*c + e + "^2" + " + " + (a*d + b*c) + e + " + " + (b*d);
		return answer;
	}
// PART 2
	public static boolean isDivisibleBy(int a, int b) { // a call to isDivisibleBy determines whether or not one integer is divisible by another, accepts two integers and returns a boolean
		if(b==0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		boolean answer = true;
		answer = (a%b) == 0;
		return answer;
	}
	public static double absValue(double a) { // a call to absVal returns the absolute value of the number passed, accepts and returns and double
		double answer = 0;
		answer = a*((2*a+1)%2);
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
		double max = 0;
		if(a>b) {
			max = a;
		} else {
			max = b;
		}
		return max;
	}
	public static double max(double a, double b, double c) { // a call to max returns the larger of the three passed, accepts three doubles and returns a double
		double max = 0;
		if(a>b) {
			max = a;
		} else {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		return max;
	}
	public static int min(int a, int b) { // a call to min returns the smaller of the two passed, accepts two integers and returns an integer
		if(a<b) { 
			return a;
		} else {
			return b;
		}
	}
	public static double round2(double a) { // a call to round2 returns the number correctly rounded to two decimal places, accepts and returns a double
		if(a>=0) {
			a = a + .005;
		} else if (a<0) {
			a = a -.005;
		}
		a = a * 100;
		a = (int) a;
		a = (double)a/100;
		return(a);
	}
// PART 3
	public static double exponent(double a, int power) { // a call to exponent returns the first number to the second number's power, accepts a double and an integer and returns a double
		int i = 1;
		double multiplier = a;
		if(power>=0) {
			while(i != power) {
				a = a * multiplier;
				i++;
			}
		} else if(power<0) {
			a = 1/a;
		}
		return a;
	}
	public static int factorial(int a) { // a call to factorial returns the factorial of the value passed, accepts and returns an integer
		int i = 1;
		int n = 1;
		if(a==0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		while(i != a) {
			i++;
			n = i * n;
		}
		return n;
	}
	public static boolean isPrime(int a) { // a call to isPrime determines whether or not the number passed is prime, accepts an integer and returns a boolean
		int counter = 0;
		for(int i = 1;i <= a;i++) {
			if(Calculate.isDivisibleBy(a,i)==true) {
				counter++;
			}
		}
		if(counter > 2) {
			return false;
		} else {
			return true;
		}
	}
	public static int gcf(int a, int b) { // a call to gfc determines the greatest common factor of the two passed integers, accepts two integers and returns one answer
		int min = (int)Calculate.min(a,b);
		for(int i = min;i>=1;i--) {
			if(a%i==0 && b%i==0) {
				return i;
			}
		}		
	return 1;
	}
	public static double sqrt(double a) { // a call to sqrt find the square root of the variable passed rounded to the nearest two decimal places, accepts and returns a double
		if(a<0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		/* double guess = a;
		while(guess*guess-a>=0.005) {
			guess = guess - 0.0001;
		}*/
		double guess = a/2;
		if (a>=0) {
			while(guess*guess - a >= 0.005||guess*guess - a <= -0.005) {
				guess = .5 * (a/guess + guess);
			}
		}
		return Calculate.round2(guess);
	}
	public static String quadForm(int a, int b, int c) { // a call of quadForm finds the roots of the three coefficients of the quadratic equation in standard form passed, accepts three integers and returns a String
		double disc = Calculate.discriminant(a,b,c);
		double answerplus = Calculate.round2((-b + Calculate.sqrt(disc))/(2*a));
		double answerminus = Calculate.round2((-b - Calculate.sqrt(disc))/(2*a));
		String finalanswer = "no real roots";
		if(disc<0) {
			finalanswer = "no real roots";
		} else if (answerminus == answerplus) {
			finalanswer = answerminus + "";
		} else if (answerminus != answerplus) {
			finalanswer = (answerplus + " and " + answerminus);
		}
		return finalanswer;
	}
}






