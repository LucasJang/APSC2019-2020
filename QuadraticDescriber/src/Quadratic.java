
public class Quadratic {
	public static double discriminant(double a, double b, double c) { // a call to discriminant returns the discriminant of the three coefficients of a quadratic passed, accepts three doubles and returns one double
		double answer = 0;
		answer = (b * b) - (4 * a * c);
		return answer;
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
		return round2(guess);
	}
	public static String quadForm(double a, double b, double c) { // a call of quadForm finds the roots of the three coefficients of the quadratic equation in standard form passed, accepts three integers and returns a String
		double disc = discriminant(a,b,c);
		double answerplus = round2((-b + sqrt(disc))/(2*a));
		double answerminus = round2((-b - sqrt(disc))/(2*a));
		String finalanswer = "no real roots";
		if(disc<0) {
			finalanswer = "no real roots" + "y = " + c;
		} else if (answerminus == answerplus) {
			finalanswer = "x-intercept: " + answerminus + "\n" + "y-intercept: " + c;
		} else if (answerminus != answerplus) {
			finalanswer = ("x-intercepts: " + answerplus + " & " + answerminus + "\n" + "y-intercept: " + c);
		} else if (disc<0 && c == 0) {
			finalanswer = "no real roots and no y-intercept";
		}
		return finalanswer;
	}
	public static String quadrDescriber(double a, double b, double c) {
		String direction = "";
		if(a>0) {
			direction = "Opens Up";
		} else if(a<0){
			direction = "Opens Down";
		}
		double x = (-b)/(2*a);
		double y = a*(x*x)+b*x+c;
		String desc = a + " x^2 + " + b + " x + " + c;
		String symm = x + "";
		String vertex = (x + ", " + y);
		String roots = quadForm(a,b,c);
		return ("Description of Graph:" + "\n" + desc + "\n" + "\n" + "Axis of Symmetry: " + symm + "\n" + "Direction: " + direction + "\n" + "Vertex: " + vertex + "\n" + roots);
		
	}
}
