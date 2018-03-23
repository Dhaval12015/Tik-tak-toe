public class Player 
{
	String name;
	String logo;
	
	Player(String name,String logo)
	{
		this.name = name;
		this.logo = logo;
	}
	
	
	
	public void printResult()
	{
		System.out.println("\n"+this.name+" win the match");
	}

	public void showBoard(String[][] board)  //for printing the board
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
				System.out.print(board[i][j] + "|");
			System.out.println();
		}
	}
}

