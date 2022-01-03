package gamebattleship;


public class Board {
    private int[][] board = new int[10][10];
    
    public void setBoard(int y, int x, int board)
    {
        this.board[y][x] = board;
    }
    public int getBoard(int y, int x)
    {
        return this.board[y][x];
    }
    public void setShip(int y, int x, int lenght, String direction)
    {
        int i;
        if(direction.equals("north"))
        {
            for(i = y ; i > y-lenght ; i--)
                setBoard(i, x, 5);
        }
        if(direction.equals("south"))
        {
            for(i = y ; i < y+lenght ; i++)
                setBoard(i, x, 5);
        }  
        if(direction.equals("west"))
        {
            for(i = x ; i > x-lenght ; i--)
                setBoard(y, i, 5);
        }
        if(direction.equals("east"))
        {
            for(i = x ; i < x+lenght ; i++)
                setBoard(y, i, 5);
        }          
        
        
    }
    public void drawBoard()
    {
        int x, y;
        System.out.print(" ");
        for(y=0 ; y<10 ; y++)
            System.out.print(" " + y);
        System.out.println("");
        
        for(y=0 ; y<10 ; y++)
        {
            if (y==0) System.out.print("A");     
            else if (y==1) System.out.print("B");
            else if (y==2) System.out.print("C");
            else if (y==3) System.out.print("D");
            else if (y==4) System.out.print("E");
            else if (y==5) System.out.print("F");
            else if (y==6) System.out.print("G");
            else if (y==7) System.out.print("H");
            else if (y==8) System.out.print("I");
            else System.out.print("J");
            
            for(x=0 ; x<10 ; x++)
            {
                System.out.print("|");
                if(this.board[y][x]==0) System.out.print(" "); //0 - brak statku
                else if(this.board[y][x]==1) System.out.print("O"); // 1 pudlo
                else if(this.board[y][x]==2) System.out.print("*"); // 2 trafienie
                else if(this.board[y][x]==5) System.out.print("S"); // 5 statek gracza
                else if(this.board[y][x]==7) System.out.print("X"); // 7 zniszczenie
            }
            System.out.print("|");
            System.out.println("");
            
        }
    }
    

    
    
    
}
