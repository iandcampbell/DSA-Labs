/**
 * A solution to the knights tour problem that
 * generates an N x N grid.
 * 
 * @author Christopher Kinney
 */
public class KnightsTour {
	//attributes
	public int n;
	
	//Default Constructor for KnightsTour
	public KnightsTour() {
		n = 8;
	}
	
	//Constructor for KnightsTour that solves for an
	//N x N board
	public KnightsTour(int num){
		n = num;
	}
	
	//Checks if a space on the board is free, or valid.
	private boolean spaceFree(int x, int y, int sol[][]) {
		return (x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == -1);
	}
	
	//Prints the solution matrix
	private void printSolution(int sol[][]) {
		for(int x = 0; x < n; x ++) {
			for(int y = 0; y < n; y++) {
				System.out.print(sol[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	//Solves the Knights Tour problem
	public boolean solveKT() {
		int sol[][] = new int[n][n];
		
		//Initializes matrix
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y ++) {
				sol[x][y] = -1;
			}
		}
		
		//sol[2][2] = -2; //temp: trying to make a hole
		
		//Defines moveset for the Knight
		int movesX[] = {2, 1, -1, -2, -2, -1, 1, 2};
		int movesY[] = {1, 2, 2, 1, -1, -2, -2, -1};
		
		//Starting at the first coordinate
		sol[0][0] = 0;
		
		//Explores all tours
		if(!solveKTUtil(0, 0, 1, sol, movesX, movesY)) {
			System.out.println("No solution exists");
			return false;
		}
		else {
			printSolution(sol);
		}
		return true;
	}
	
	//A recursive utility for solveKT
	private boolean solveKTUtil(int x, int y, int moveCheck, int sol[][],int movesX[], int movesY[]) {
		int next_X, next_Y;
		if(moveCheck == n * n) {   //temp: may try to poke a hole (subtracting holes)
			return true;
		}
		
		//Try all moves from the current coordinate (x, y)
		for(int i = 0; i < 8; i++) {
			next_X = x + movesX[i];
			next_Y = y + movesY[i];
			if(spaceFree(next_X, next_Y, sol)) {
				sol[next_X][next_Y] = moveCheck;
				if(solveKTUtil(next_X, next_Y, moveCheck + 1, sol, movesX, movesY)) {
					return true;
				}
				else {
					sol[next_X][next_Y] = -1; //backtracks
				}
			}
			//printSolution(sol);                   //wanted to see each step it took
			//System.out.println();                 //vastly increased runtime for even an 8x8
		}
		return false;
	}
}
