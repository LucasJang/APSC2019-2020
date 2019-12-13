package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	System.out.print("Hello, Welcome to FracCalc.  ");
    	String answer = "yes";
    	while("yes".equalsIgnoreCase(answer)) {
        	System.out.println("Please enter your problem");
        	String problem = input.nextLine();
        	System.out.println(produceAnswer(problem));
        	System.out.println("Would you like to continue? Type \"Yes\" to continue or \"quit\" to quit");
        	answer = input.nextLine();
    	}
    	System.out.println("Thank you! Until nextime.");

    }

 // Checkpoint 3 
    public static String produceAnswer(String input) { 
        // Split at spaces
    	String[] split_input = input.split(" ");
        
    	// Check number of terms and operators
    	int num_terms = (split_input.length/2) + 1;
    	int num_operators = split_input.length - num_terms;
    	
    	// Arrays of list of terms and operators
    	String[] operators = new String[num_operators];
    	String[] terms = new String[num_terms];
    	int counterfrom1 = 1;
    	for(int i = 0; i < num_operators; i++) {
    		operators[i] = split_input[counterfrom1];
    		counterfrom1 = counterfrom1 + 2;
    	}
    	int counterfrom0 = 0;
    	for(int i = 0; i < num_terms; i++) {
    		terms[i] = split_input[counterfrom0];
    		counterfrom0 = counterfrom0 + 2;
    	}
    	
    	// Doing Multiple Operations
    	int[] answer = toImproper(terms[0]);
    	for(int i = 0; i < num_operators; i++) {
    		
    		// First Operand
    		int[] term1 = new int[2];
    		term1 = answer;
    		
    		// Second Operand
    		int[] term2 = new int[2];
    		term2 = toImproper(terms[i + 1]);
    		
    		// Checking Operator
    		String operator = operators[i];
    		if(operator.length() != 1) {
    			throw new IllegalArgumentException("ERROR: Input is in an invalid format."); 
    		}
    		
    		// Actually doing Operation
    		answer = operate(term1, term2, operator);
    	}
        simplify(answer);
        String simp_answer = "";
        if(Math.abs(answer[1]) == 1) {
        	simp_answer = answer[0] * answer[1] + "";
    	} else if(Math.abs(answer[0]) > Math.abs(answer[1])) {
    		int whole = answer[0]/answer[1];
    		simp_answer = whole + "_" + Math.abs(answer[0] - whole * answer[1]) + "/" + Math.abs(answer[1]);
    	} else if(answer[0] == answer[1]) {
    		simp_answer = "1";
    	} else {
            simp_answer = answer[0] + "/" + answer[1];
        }
        return simp_answer;
    }
    
// Extra Methods
    	// Does one operation between two terms
    	public static int[] operate(int[] term1, int[] term2, String operator) {
    		
    		// Prime answer
    		int[] answer1 = new int[2];
    		
    		// Checking the operators
    		if(operator.equalsIgnoreCase("*") || operator.equalsIgnoreCase("/")) { // Multiplication and Division Case
    			if(operator.equalsIgnoreCase("/")) {
    				int temp = term2[0];
    				term2[0] = term2[1];
    				term2[1] = temp;
    			}
    			answer1[0] = term1[0] * term2[0];
    			answer1[1] = term1[1] * term2[1];
    		} else if(operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-")) { // Addition and Subtraction Case
    			int lcm = lcm(term1[1],term2[1]);
    			if(operator.equalsIgnoreCase("+")) {
    				answer1[0] = (term1[0] * (lcm/term1[1])) + (term2[0] * (lcm/term2[1]));
    				answer1[1] = lcm;
    			} else {
    				answer1[0] = (term1[0] * (lcm/term1[1])) - (term2[0] * (lcm/term2[1]));
    				answer1[1] = lcm;
    			}
    		}
    		return answer1;
		}	
    	
    	// Turns everything into improper fraction
    	public static int[] toImproper(String operand) {
    	int[] superterm = new int[2];
	    	if(operand.contains("_") && operand.contains("/")) { // Mixed Number
	        	String[] split_input = operand.split("_");
	        	String[] frac = split_input[1].split("/");
	        	if(Integer.parseInt(split_input[0]) < 0) {
	        		superterm[0] = Integer.parseInt(split_input[0]) * Integer.parseInt(frac[1]) + (Integer.parseInt(frac[0]) * -1);
	        		superterm[1] = Integer.parseInt(frac[1]);
	        		if(superterm[1] == 0) {
	        			throw new IllegalArgumentException("ERROR: Cannot divide by zero"); 
	        		}
	        	} else {
	        		superterm[0] = Integer.parseInt(split_input[0]) * Integer.parseInt(frac[1]) + Integer.parseInt(frac[0]);
	        		superterm[1] = Integer.parseInt(frac[1]);
	        		if(superterm[1] == 0) {
	        			throw new IllegalArgumentException("ERROR: Cannot divide by zero"); 
	        		}
	        	}
	    	} else if(operand.contains("/") && !operand.contains("_")) { // Fraction
	    		superterm[0] = Integer.parseInt((operand.split("/"))[0]);
	    		superterm[1] = Integer.parseInt((operand.split("/"))[1]);
	    		if(superterm[1] == 0) {
	    			throw new IllegalArgumentException("ERROR: Cannot divide by zero"); 
	    		}
	    	} else { // Whole number
	    		superterm[0] = Integer.parseInt(operand);
	    		superterm[1] = 1;
	    	}
	    	return superterm;
    	}
    
	    // Finds least common denominator
	    public static int lcm(int num1, int num2) {
			int max = Math.abs(num2);
			int min = Math.abs(num1);
			if(num1>num2) { 
				max = Math.abs(num1);
				min = Math.abs(num2);
			}
			int lcm = max;
			while(lcm%min!=0) {
				lcm+=max;
			}
			return lcm;
	    }
	    
	    // Simplifies fraction array w/ numerator and denominator
	    public static void simplify(int[] improp) {
	    	int a = Math.abs(improp[0]);
	    	int b = Math.abs(improp[1]);
	    	if(a == 0) {
	    		improp[0] = 0;
	    		improp[1] = 1;
	    	} else {
	    		int gcf = 0;
	        	int minimum = Math.min(a,b);
	    		for(int i = 1; i <= minimum; i++) {
	    			if(a%i == 0 && b%i == 0) {
	    				gcf= Math.abs(i);
	    			}
	    		}
	    		improp[0] = improp[0]/gcf;
	    		improp[1] = improp[1]/gcf;
	    		if(improp[0] > 0 && improp[1] < 0) {
	    			improp[0] = -improp[0];
	    			improp[1] = -improp[1];
	    		}
	    	}
	    }
	}