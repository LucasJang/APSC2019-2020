// Lucas Jang
// August 29, 2019
// Period 4
// Call math methods from Calculate Library
// Client code or runner code

public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(3));
		System.out.println(Calculate.cube(4));
		System.out.println(Calculate.average(2,3));
		System.out.println(Calculate.average(4,6,13));
		System.out.println(Calculate.toDegrees(30));
		System.out.println(Calculate.toRadians(30));
		System.out.println(Calculate.discriminant(3,5,7));
		System.out.println(Calculate.toImproperFrac(3,1,2));
		System.out.println(Calculate.toMixedNum(7,2));
		System.out.println(Calculate.foil(2,3,6,-7,"n"));
		System.out.println(Calculate.isDivisibleBy(4,3));
		System.out.println(Calculate.absValue(-10));
		System.out.println(Calculate.max(3,7));
		System.out.println(Calculate.max(1234,5,45));
		System.out.println(Calculate.min(4,23456543));
		System.out.println(Calculate.round2(454.23434));
		System.out.println(Calculate.exponent(2,6));
		System.out.println(Calculate.factorial(9));
		System.out.println(Calculate.isPrime(1123478543));
		System.out.println(Calculate.gfc(8,16));
	}

}
