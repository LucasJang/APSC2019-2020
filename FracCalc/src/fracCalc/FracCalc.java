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
    	String[] operators = new String[num_operators];
    	int op_counter = 1;
    	for(int i = 0; i < num_operators - 1; i++) {
    		operators[i] = split_input[op_counter];
    		op_counter = op_counter + 2;
    	}
    	System.out.println(Arrays.toString(operators));
    	
    	
    	// First Operand
    	int[] term1 = new int[2];
    	term1 = constant(split_input[0]);
    	
    	// Second Operand
        int[] term2 = new int[2];
    	term2 = constant(split_input[2]);
    	
    	// Prime answer
        int[] answer = new int[2];
        
        // Checking the operators
        if(split_input[1].equalsIgnoreCase("*") || split_input[1].equalsIgnoreCase("/")) { // Multiplication and Division Case
        	if(split_input[1].equalsIgnoreCase("/")) {
        		int temp = term2[0];
        		term2[0] = term2[1];
        		term2[1] = temp;
        	}
        	answer[0] = term1[0] * term2[0];
        	answer[1] = term1[1] * term2[1];
        } else if(split_input[1].equalsIgnoreCase("+") || split_input[1].equalsIgnoreCase("-")) { // Addition and Subtraction Case
        	int lcm = lcm(term1[1],term2[1]);
        	if(split_input[1].equalsIgnoreCase("+")) {
        		answer[0] = (term1[0] * (lcm/term1[1])) + (term2[0] * (lcm/term2[1]));
        		answer[1] = lcm;
        	} else {
        		answer[0] = (term1[0] * (lcm/term1[1])) - (term2[0] * (lcm/term2[1]));
        		answer[1] = lcm;
        	}
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
    	// Turns everything into improper fraction
    	public static int[] constant(String operand) {
    	int[] superterm = new int[2];
    	if(operand.contains("_") && operand.contains("/")) { // Mixed Number
    		superterm = mixedToimproper(operand);
    	} else if(operand.contains("/") && !operand.contains("_")) { // Fraction
    		superterm[0] = Integer.parseInt((operand.split("/"))[0]);
    		superterm[1] = Integer.parseInt((operand.split("/"))[1]);
    	} else { // Whole number
    		superterm[0] = Integer.parseInt(operand);
    		superterm[1] = 1;
    	}
    	return superterm;
    }
    
    public static int[] mixedToimproper(String mixed) {
    	String[] split_input = mixed.split("_");
    	String[] frac = split_input[1].split("/");
    	int[] answer = new int[2];
    	if(Integer.parseInt(split_input[0]) < 0) {
    		answer[0] = Integer.parseInt(split_input[0]) * Integer.parseInt(frac[1]) + (Integer.parseInt(frac[0]) * -1);
    		answer[1] = Integer.parseInt(frac[1]);
    	} else {
    		answer[0] = Integer.parseInt(split_input[0]) * Integer.parseInt(frac[1]) + Integer.parseInt(frac[0]);
    		answer[1] = Integer.parseInt(frac[1]);
    	}
    	return answer;
    }
    
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