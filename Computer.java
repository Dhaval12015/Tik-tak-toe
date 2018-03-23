public class Computer
{
	String name;
	String logo;
	String[][] board;
	
	
	Computer(String name,String logo,String[][] board)
	{
		this.name = name;
		this.logo = logo;
		this.board = board;
	}
	public void setPosition(String[][] board)
	{
		int count = 0;
		count = this.defaultMove("o");
		if(count!=2)
			count = defaultMove("X");
//		System.out.println(count);
		if(count!=2)
			this.attack();
	}
	public int defaultMove(String s) //default move for critical situation like "DEFENCE" or "WINNING ATTACK"
	{
		int count = 0;
		for(int k=1;k<4;k++)
		{
				for(int i=1;i<4;i++)
				{
					if(board[i][k].equals(s))
						count++;
					if(count==2)
					{
						for(int j=1;j<4;j++)
							if(board[j][k].equals("-"))
							{
								board[j][k] = this.logo;
								return count;
							}
					}
				}
				count = 0;
		}
		
		for(int k=1;k<4;k++)
		{
			
			for(int i=1;i<4;i++)
			{
				if(board[k][i].equals(s))
					count++;
				if(count==2)
				{
					for(int j=1;j<4;j++)
						if(board[k][j].equals("-"))
						{
							board[k][j] = this.logo;
							return count;
						}
				}	
			}
			count = 0;
		}
	
		for(int i=1;i<4;i++)
		{
			if(board[i][i].equals(s))
				count++;
			if(count==2)
			{
				for(int j=1;j<4;j++)
					if(board[j][j].equals("-"))
					{
						board[j][j] = this.logo;
						return count;
					}
			}
		}
		count = 0;
		for(int i=1;i<4;i++)
		{
			if(board[i][4-i].equals(s))
				count++;
			if(count==2)
			{
				for(int j=1;j<4;j++)
					if(board[j][4-j].equals("-"))
					{
						board[j][4-j] = this.logo;
						return count;
					}
			}
		}
		
		return 0;
	}
	public void attack()
	{
			if(board[2][2].equals("-"))
			{

				board[2][2] = this.logo;
				return;
			}
			else if((board[1][1].equals("X") && board[3][3].equals("X")) || (board[1][3].equals("X") && board[3][1].equals("X")))
			{
				board[3][2] = this.logo;
			}
			else if(board[2][2].equals("X") && board[1][1].equals("-"))
				board[1][1] = this.logo;
			else
			{
				for(int i=1;i<4;i++)
					if(board[i][4-i].equals("-"))
					{	
						board[i][4-i] = this.logo;
						return;
					}
			}
	}
}

