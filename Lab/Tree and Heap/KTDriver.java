import java.util.Scanner;

public class KTDriver {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		//runs the KnightsTour class
		System.out.println("Welcome to The Knight's Tour Solution Calculator. \n"
				+ "Enter a board size greater than three: ");
		int num = scn.nextInt();
		KnightsTour kt = new KnightsTour(num);
		kt.solveKT();
		
	}

}
