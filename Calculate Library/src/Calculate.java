// Lucas Jang
// August 29, 2019
// Period 4
// Group of methods that perform math calculations aka library

public class Calculate {
// PART 1
	public static int square(int number) { // a call to square returns the square of the value passed, accepts and returns integer
		int answer = number * number;
		return answer;
	}
	public static int cube(int number) { // a call to cube returns the cube of the value passed, accepts and returns integer
		int answer = number * number * number;
		return answer;
	}
	public static double average(double number1, double number2) { // a call to average returns the average of the two values passed, accepts two doubles and returns a double
		double answer = (number1 + number2)/2.0;
		return answer;
	}
	public static double average(double number1, double number2, double number3) { // a call to average returns the average of the three values passed, accepts three doubles and returns a double
		double answer = (number1 + number2 + number3)/3.0;
		return answer;
	}
	public static double toDegrees(double radians) { // a call to toDegrees returns the conversion to degrees from radians passed, accepts and returns a double
		double answer = radians * (180/3.14159);
		return answer;
	}
	public static double toRadians(double degrees) { // a call to toRadians return the conversion to radians from degrees passed, accepts a double and returns a double
		double answer = degrees * (3.14159/180);
		return answer;
	}
	public static double discriminant(double a, double b, double c) { // a call to discriminant returns the discriminant of the three coefficients of a quadratic passed, accepts three doubles and returns one double
		double answer = 0;
		answer = (b * b) - (4 * a * c);
		return answer;
	}
	public static String toImproperFrac(int whole, int num, int denom) { // a call to toImproperFrac returns an improper fraction converted from a mixed number, accepts three integers and returns a string
		String answer = (whole * denom) + num + "/" + denom;
		return answer;
	}
	public static String toMixedNum(int num, int denom) { // a call to toMixedNum returns a mixed number converted from an improper fraction, accepts two integers and returns a string
		int whole = num/denom;
		String answer = whole + "_" + (num%denom) + "/" + denom;
		return answer;
	}
	public static String foil(int a, int b, int c, int d, String variable) { // a call to foil returns a quadratic equation from a binomial, accepts four integers and one string and returns a string
		String answer = a*c + variable + "^2 + " + (a*d + b*c) + variable + " + " + (b*d);
		return answer;
	}
// PART 2
	public static boolean isDivisibleBy(int num, int denom) { // a call to isDivisibleBy determines whether or not one integer is divisible by another, accepts two integers and returns a boolean
		if(denom==0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		boolean answer = (num%denom) == 0;
		return answer;
	}
	public static double absValue(double number) { // a call to absVal returns the absolute value of the number passed, accepts and returns and double
	 		double answer = 0;
			if(number < 0) {
	      	answer = number * -1;
	      } else {
				answer = number;
		  }
		  return answer;
	}
	public static double max(double number1, double number2) { // a call to max returns the larger of the two passed, accepts two doubles and returns a double
		double max = 0;
		if(number1>number2) {
			max = number1;
		} else {
			max = number2;
		}
		return max;
	}
	public static int max(int number1, int number2) { // a call to max returns the larger of the two passed, accepts two doubles and returns a double
		int max = 0;
		if(number1>number2) {
			max = number1;
		} else {
			max = number2;
		}
		return max;
	}
	public static double max(double number1, double number2, double number3) { // a call to max returns the larger of the three passed, accepts three doubles and returns a double
		double max = 0;
		if(number1>number2) {
			max = number1;
		} else {
			max = number2;
		}
		if(number3>max) {
			max = number3;
		}
		return max;
	}
	public static int min(int number1, int number2) { // a call to min returns the smaller of the two passed, accepts two integers and returns an integer
		if(number1<number2) { 
			return number1;
		} else {
			return number2;
		}
	}
	public static double min(double number1, double number2) { // a call to min returns the smaller of the two passed, accepts two integers and returns an integer
		if(number1<number2) { 
			return number1;
		} else {
			return number2;
		}
	}
	public static double round2(double number) { // a call to round2 returns the number correctly rounded to two decimal places, accepts and returns a double
		if(number>=0) {
			number = number + .005;
		} else if (number<0) {
			number = number -.005;
		}
		number = number * 100;
		number = (int) number;
		number = (double)number/100;
		return(number);
	}
// PART 3
	public static double exponent(double base, int exp) { // a call to exponent returns the first number to the second number's power, accepts a double and an integer and returns a double
		int exp_counter = 1;
		double multiplier = base;
		if(exp>=0) {
			while(exp_counter != exp) {
				base = base * multiplier;
				exp_counter++;
			}
		} else if(exp<0) {
			base = 1/base;
		}
		return base;
	}
	public static int factorial(int fact) { // a call to factorial returns the factorial of the value passed, accepts and returns an integer
		int answer = 1;
		if (fact < 0) {
			throw new IllegalArgumentException("Number must be greater than 0"); 
		}
		for (int i = 1; i <= fact; i++) {
			answer *= i;
		}
		return answer;
	}
	public static boolean isPrime(int number) { // a call to isPrime determines whether or not the number passed is prime, accepts an integer and returns a boolean
		int counter = 0;
		for(int i = 1;i <= number;i++) {
			if(isDivisibleBy(number,i)==true) {
				counter++;
			}
		}
		if(counter > 2) {
			return false;
		} else {
			return true;
		}
	}
	public static int gcf(int number1, int number2) { // a call to gfc determines the greatest common factor of the two passed integers, accepts two integers and returns one answer
		int max = max(number1,number2);
		int min = min(number1,number2);
		for(int i = min; i <= max; i++) {
			if(number1%i==0 && number2%i==0) {
				return i;
			}
		}		
	return 1;
	}
	public static double sqrt(double base) { // a call to sqrt find the square root of the variable passed rounded to the nearest two decimal places, accepts and returns a double
		if(base<0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		double guess = base/2;
		if (base>=0) {
			while(guess * guess - base >= 0.005 || guess * guess - base <= -0.005) {
				guess = .5 * (base/guess + guess);
			}
		}
		return round2(guess);
	}
	public static String quadForm(int a, int b, int c) { // a call of quadForm finds the roots of the three coefficients of the quadratic equation in standard form passed, accepts three integers and returns a String
		double root1 = round2((-b + sqrt(discriminant(a,b,c)))/(2*a));
		double root2 = round2((-b - sqrt(discriminant(a,b,c)))/(2*a));
		String finalanswer = "no real roots";
		if(discriminant(a,b,c)<0) {
			finalanswer = "no real roots";
		} else if (root2 == root1) {
			finalanswer = root2 + "";
		} else if (root2 != root1) {
			finalanswer = (root1 + " and " + root2);
		}
		return finalanswer;
	}
}