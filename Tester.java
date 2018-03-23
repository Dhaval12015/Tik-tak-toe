             
import java.util.Scanner;
public class Tester 
{
	public static void main(String[] args)
	{
		 String board[][] = new String[4][4];
		 for(int i=0;i<4;i++)
		 {
			 for(int j=0;j<4;j++)
				 board[i][j]="-";
		 }
		 board[0][1] = "1";
		 board[0][2] = "2";
		 board[0][3] = "3";
		 board[1][0] = "1";
		 board[2][0] = "2";
		 board[3][0] = "3";
		 board[0][0] = "*";
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Player's Name: ");
		 String player1 = sc.nextLine();
	
		Player p1 = new Player(player1,"X");
		Computer c1 = new Computer("CPU","o",board);
		
		int flag=0; //flag for if match is DRAW or not....
		p1.showBoard(board);
		for(int i=0;i<9;i++)
		{
			int m ,n;
			if(i%2==0)
			{
				System.out.println(p1.name+"'s Turn");
				m = sc.nextInt();
				n = sc.nextInt();
				board[m][n] = p1.logo;
			}
			else
			{
				System.out.println(c1.name+"'s Turn");
				c1.setPosition(board);
			}
	
			if(winningStatus(board,p1.logo)) 
			{
				flag++;;
	
				p1.printResult();
				p1.showBoard(board);
				break;
			}
			if(winningStatus(board,c1.logo))
			{
				flag++;
				System.out.println("Cpu win the match!!");
				p1.showBoard(board);
				break;
			}
			p1.showBoard(board);
		
		}
		if(flag==0)
			System.out.println("Match is Draw");
			sc.close();
	}
	public static boolean winningStatus(String[][] board,String logo) //it returns if match is win by anyone??
	{
		
		if(board[1][1].equals(logo) && board[1][2].equals(logo) && board[1][3].equals(logo))
			return true;
		else if(board[2][1].equals(logo) && board[2][2].equals(logo) && board[2][3].equals(logo))
		return true;
		else if(board[3][1].equals(logo) && board[3][2].equals(logo) && board[3][3].equals(logo))
			return true;
		else if(board[1][1].equals(logo) && board[2][2].equals(logo) && board[3][3].equals(logo))
			return true;
		else if(board[1][1].equals(logo) && board[2][1].equals(logo) && board[3][1].equals(logo))
			return true;
			else if(board[1][2].equals(logo) && board[2][2].equals(logo) && board[3][2].equals(logo))
				return true;
			else if(board[1][3].equals(logo) && board[2][3].equals(logo) && board[3][3].equals(logo))
				return true;
			else if(board[1][3].equals(logo) && board[2][2].equals(logo) && board[3][1].equals(logo))
				return true;
				else
			return false;
	}
}


