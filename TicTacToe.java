import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> CpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		char [] [] gameboard = {{' ','|' ,' ', '|', ' ' },
				{'-','+' ,'-', '+', '-' },
				{' ','|' ,' ', '|', ' ' },
				{'-','+' ,'-', '+', '-' },
				{' ','|' ,' ', '|', ' ' }};
		printGameboard(gameboard);
		
       while(true) {
		
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter your placement (1-9) : ");
		 int playerPos = scan.nextInt();
		 while(playerPositions.contains(playerPos) || CpuPositions.contains(playerPositions)); {
		System.out.println("Position taken enter a correct position");
		playerPos = scan.nextInt();
		
		 }
		placeP(gameboard,playerPos,"player");
		
		 String result = checkWinner();
		 if (result.length() > 0) {
		 System.out.println(result);
		 break;
		 }
		
		 //placeP(gameboard,pos,"cpu");
		 
		 Random rand = new Random();
		 int cpuPos = rand.nextInt(9) +1;
		 while(playerPositions.contains(cpuPos) || CpuPositions.contains(CpuPositions)); {
				System.out.println("Position taken enter a correct position");
				cpuPos = rand.nextInt(9) + 1;
		 }
		 
		 placeP(gameboard,cpuPos,"cpu");
		 
		 printGameboard(gameboard);
		 
		  result = checkWinner();
		 if (result.length() > 0) {
		 System.out.println(result);
		 break;
		 }
	        }
	}
	
	
	public static void printGameboard(char [] [] gameboard)
	{
	
		for (char [] row : gameboard) 
		{
			for (char c : row) 
			{
				System.out.print(c);
	        }
			System.out.println();
		}
	

	}

	
	public static void placeP(char[] [] gameboard , int pos ,String user)
	{
		char symbol = ' ';
		if (user.equals("player") ) {
			symbol= 'X';
			playerPositions.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			CpuPositions.add(pos);
		}
		
		switch(pos) {
		case 1 : 
			gameboard[0] [0] = symbol;
			break;
		case 2 : 
			gameboard[0] [2] = symbol;
			break;
		case 3 : 
			gameboard[0] [4] = symbol;
			break;
		case 4 : 
			gameboard[2] [0] = symbol;
			break;
		case 5 : 
			gameboard[2] [2] = symbol;
			break;
		case 6 : 
			gameboard[2] [4] = symbol;
			break;
		case 7 : 
			gameboard[4] [0] = symbol;
			break;
		case 8 : 
			gameboard[4] [2] = symbol;
			break;
		case 9 : 
			gameboard[4] [4] = symbol;
			break;
		default :
			break;
			
		}
		
	}

	public static String checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List lefCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(lefCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning)
		{
			if (playerPositions.containsAll(l)) {
				return "Congo You Won";
			} else if (CpuPositions.containsAll(l)) {
				return ""
						+ "CPU Won!";
			} else if (playerPositions.size() + CpuPositions.size() == 9) {
				return "Tie!";
			}
		}
		
		
		return "";
		
		
	}
	

}
