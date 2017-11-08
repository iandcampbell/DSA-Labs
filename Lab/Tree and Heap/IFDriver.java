import java.util.Scanner;

public class IFDriver {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean done = false;
		
		//runs the InFixCalc class
		System.out.println("This is the InFix Calculator. \n" 
				+ "Enter an equation with no spaces: ");
		//forces correct input format
		String form = "";
		while(!done) {
			form = scn.nextLine();
			if(!(form.matches("^(([0-9])*(([+]|[-]|[*]|[/])([0-9])*)*)$"))) {
				System.out.print("INVALID INPUT! Try Again: ");
				form = scn.nextLine();
			}
			else {
				done = true;
			}
		}
		//passes input to the calculator
		InFixCalc ifCalc = new InFixCalc(form); //also outputs answer
		
	}

}
