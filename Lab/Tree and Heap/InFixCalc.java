/**
 * 
 * @author Christopher Kinney
 */
public class InFixCalc {
	//attributes
	public String eq;   //the equation we manipulate
	
	/**
	 * Constructor for InFixCalc
	 * Converts the infix equation to a postfix state,
	 *then calls on PostFixCalc to perform the operations.
	 */
	public InFixCalc(String eq){
		this.eq = eq;
		//PostFixCalc post = new PostFixCalc(convertTo(eq));
		System.out.println(convertTo(eq));   //temp: for testing
	}
	
	//Assigns an integer value indicating precedence
	//to operators
	private int precedence(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	
	//Performs the conversion from infix to postfix
	private String convertTo(String eq) {
		char[] array = new char[eq.length()];  //functionally a stack
		String result = "";
		
		//handles present position
		int j = 0;
		
		//iterates
		for(int i = 0; i < eq.length(); i++) {
			//Grabs a character of the string in sequence
			char c = eq.charAt(i);
			//adds the character to output if it is an operand
			if(Character.isLetterOrDigit(c)) {
				result += c;
			}
			//Adds to the array
			else if(c == '(') {
				array[j] = c;
				j++;
			}
			//checks parenthesis
			else if(c == ')') {
				//removes all ')' from the array
				while(j != 0 && array[j-1] != '(') {
					result += array[j];
					j--;
				}
				//checks for an invalid expression
				if(j != 0 && array[j-1] != '(') {
					return "Invalid Expression";
				}
				else {
					j--;
				}
			}
			//when an operator is encountered
			else {
				while(j != 0 && precedence(c) <= precedence(array[j-1])) {
					result += array[j];
					j--;
				}
				array[j] = c;
				j++;
			}
		}
		//removes all operators from the array
		while(j != 0) {
			result += array[j];
			j--;
		}
		return result;
	}
}
