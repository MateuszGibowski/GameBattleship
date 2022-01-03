package gamebattleship;

import java.util.Scanner;


public class Move {
    
    Board board = new Board();
  //  FirstMove firstMove = new FirstMove();
//    Ship battleship = new Ship("battleship");
//    Ship cruiser = new Ship("cruiser");
//    Ship destroyer = new Ship("destroyer");    
//    Ship boat = new Ship("boat");
//    public Scanner scanner = new Scanner(System.in);
  //  Move move = new Move();

    Move(Board board)
    {
        this.board = board;
    }
        
    private int y, x;
    
    public int checkDirection(int y, int x, String direction)
    {
        switch (direction)
        {
            case "north":
                return checkNorth(y, x);         
            case "south":
                return checkSouth(y, x);
            case "west":
                return checkWest(y, x);
            case "east":
                return checkEast(y, x); 
        }
        return 0;        
    }
    
    
    
    private int checkNorth(int y, int x)
    {
        if(y-1 < 0)
            return -1;
        else
            return board.getBoard(y-1, x);
    }
    private int checkSouth(int y, int x)
    {
        if(y+1 > 9)
            return -1;
        else
            return board.getBoard(y+1, x);
    }
    private int checkEast(int y, int x)
    {
        if(x+1 > 9)
            return -1;
        else
            return board.getBoard(y, x+1);
    }
    private int checkWest(int y, int x)
    {
        if(x-1 < 0)
            return -1;
        else
            return board.getBoard(y, x-1);
    }
   
    public int checkDirection(int y, int x, int lenght, String direction)
    {
        switch (direction)
        {
            case "north":
                return checkNorth(y, x, lenght);         
            case "south":
                return checkSouth(y, x, lenght);
            case "west":
                return checkWest(y, x, lenght);
            case "east":
                return checkEast(y, x, lenght); 
        }
        return 0;
    }
    
    
    private int checkNorth(int y, int x, int lenght)
    {
        if(y - (lenght-1) < 0)
            return -1;
        if(x < 0 || x > 9)
            return -1;        
        
        for(this.y = y ; this.y > y - lenght ; this.y--)
        {
            switch (board.getBoard(this.y, x)) 
            {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 5:
                    return 5;
                case 7:
                    return 7; 
            }
        }
        return 0;
    }
            

    private int checkSouth(int y, int x, int lenght)
    {
        if(y + (lenght-1) > 9)
            return -1;
        if(x > 9 || x < 0)
            return -1;        
        
        for(this.y = y ; this.y < y + lenght ; this.y++)
        {
            switch (board.getBoard(this.y, x)) 
            {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 5:
                    return 5;
                case 7:
                    return 7; 
            }
        } 
        return 0;
    }

    private int checkEast(int y, int x, int lenght)
    { 
        if(x + (lenght-1) > 9)
            return -1;
        if(y > 9 || y < 0)
            return -1;
        
        for(this.x = x ; this.x < x + lenght ; this.x++)
        {
            switch (board.getBoard(y, this.x)) 
            {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 5:
                    return 5;
                case 7:
                    return 7; 
            }
        }
        
        return 0;
    }

    private int checkWest(int y, int x, int lenght)
    {
        if(x - (lenght-1) < 0)
            return -1;
        if(y < 0 || y > 9)
            return -1;
        
        for(this.x = x ; this.x > x - lenght ; this.x--)
        {
            switch (board.getBoard(y, this.x)) 
            {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 5:
                    return 5;
                case 7:
                    return 7; 
            }
        }
        
        return 0;
    }
               
}
