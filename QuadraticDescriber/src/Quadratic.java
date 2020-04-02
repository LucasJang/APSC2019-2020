
public class Quadratic {
	public static double discriminant(double a, double b, double c) { // a call to discriminant returns the discriminant of the three coefficients of a quadratic passed, accepts three doubles and returns one double
		double answer = 0;
		answer = (b * b) - (4 * a * c);  // Discriminant formula
		return answer;
	}
	public static double round2(double num) { // a call to round2 returns the number correctly rounded to two decimal places, accepts and returns a double
		if(num>=0) {
			num = num + .005;  // Positive input case
		} else if (num<0) {
			num = num -.005;  // Negative input case
		}
		num = num * 100;
		num = (int) num;
		num = (double)num/100;
		return(num);
	}
	public static double sqrt(double base) { // a call to sqrt find the square root of the variable passed rounded to the nearest two decimal places, accepts and returns a double
		if(base<0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		double guess = base/2;
		if (base>=0) {
			while(guess*guess - base >= 0.005||guess*guess - base <= -0.005) {
				guess = .5 * (base/guess + guess);
			}
		}
		return round2(guess);
	}
	public static String quadForm(double a, double b, double c) { // a call of quadForm finds the roots of the three coefficients of the quadratic equation in standard form passed, accepts three integers and returns a String
		double disc = discriminant(a,b,c);
		double answerplus = round2((-b + sqrt(disc))/(2*a));  // Addition case
		double answerminus = round2((-b - sqrt(disc))/(2*a));  // Subtraction case
		String finalanswer = "no real roots";
		if(disc<0) {
			finalanswer = "no real roots" + "y = " + c;  // If there are no real roots
		} else if (answerminus == answerplus) {
			finalanswer = "x-intercept: " + answerminus + "\n" + "y-intercept: " + c;  // If there is only one root
		} else if (answerminus != answerplus) {
			finalanswer = ("x-intercepts: " + answerplus + " & " + answerminus + "\n" + "y-intercept: " + c);  // If there are 2 real roots
		} else if (disc<0 && c == 0) {
			finalanswer = "no real roots and no y-intercept"; // When there are no intercepts or roots
		}
		return finalanswer;
	}
	public static String quadrDescriber(double a, double b, double c) {
		String direction = "";
		if(a>0) {
			direction = "Opens Up";  // When a is positive, opens up 
		} else if(a<0){
			direction = "Opens Down";  // When a is negative, opens down
		}
		double x = (-b)/(2*a);  // Formula for x value of vertex
		double y = a*(x*x)+b*x+c;  // Formula for y value of vertex
		String desc = a + " x^2 + " + b + " x + " + c;
		String symm = x + "";  // Axis of Symmetry
		String vertex = (round2(x) + ", " + round2(y));  // Puts the x & y value for vertex
		String roots = quadForm(a,b,c);  // Finds the roots
		return ("Description of Graph:" + "\n" + desc + "\n" + "\n" + "Axis of Symmetry: " + symm + "\n" + "Direction: " + direction + "\n" + "Vertex: " + vertex + "\n" + roots);
		
	}
}
