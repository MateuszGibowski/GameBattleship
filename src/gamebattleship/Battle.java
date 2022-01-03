package gamebattleship;


import java.util.Random;
import java.util.Scanner;

public class Battle 
{
    private Board playerShoot = new Board();
    private Board aiShoot = new Board();
    public Scanner scanner = new Scanner(System.in);
    Move move = new Move(playerShoot);
    FirstMove firstMove = new FirstMove();
   
    public String whoFirst()
    {
        Random rand = new Random();

        int whoFirst = rand.nextInt(2);
        if(whoFirst == 0)
            return "player";
        else
            return "ai";
    }
    
    public Board shoot(Board boardEnemy, Move move, String player, Board shoot)
    {
      //  Board shoott;
        if(player.equals("player")) 
            shoot = playerShoot(boardEnemy, move, shoot);
        else
            shoot = aiShoot(boardEnemy, move, shoot);
        return shoot;
    }

    private Board aiShoot(Board boardEnemy, Move move, Board aiShoot)
    {
        return aiShoot;
    }

    private Board playerShoot(Board boardEnemy, Move move, Board playerShoot)
    {
        playerShoot.drawBoard();
        playerShoot = whereShot(boardEnemy, playerShoot);
        
        return playerShoot;
    }
    
    
    
    
    private Board whereShot(Board boardEnemy, Board playerShoot)
    {
        while(true)
        {
            System.out.println("Gdzie strzelamy Kapitanie?");
            playerShoot.drawBoard();
            int x, y;

            while(true)
            {
                String chooseField = scanner.next();
                chooseField = firstMove.convert(chooseField);
                if(chooseField.equals("error"))
                System.out.println("Błędna wartość");
                else
                {
                    y = Character.getNumericValue(chooseField.charAt(0)); 
                    x = Character.getNumericValue(chooseField.charAt(1)); 
                    if(playerShoot.getBoard(y, x) == 0)
                        break;
                    System.out.println("Tam już się nie da");
                    System.out.println("Gdzie celujemy?");
                }
            } 
            if(boardEnemy.getBoard(y, x) == 5)
            {
                playerShoot.setBoard(y, x, 2);
                boardEnemy.setBoard(y, x, 2);
                checkDestroy(y, x, boardEnemy, playerShoot);
            }
            else
               playerShoot.setBoard(y, x, 1);
            
            if(boardEnemy.getBoard(y, x) == 0)
                return playerShoot;
        }
    }

    void checkDestroy(int y, int x, Board boardEnemy, Board playerShoot)
    {
        int north = checkDestroyNorth(y, x, boardEnemy, playerShoot);
        int south = checkDestroySouth(y, x, boardEnemy, playerShoot);
        int west = checkDestroyWest(y, x, boardEnemy, playerShoot);
        int east = checkDestroyEast(y, x, boardEnemy, playerShoot);
        System.out.println("NORTH: " + north);
        System.out.println("SOUTH: " + south);
        System.out.println("WEST: " + west);
        System.out.println("EAST: " + east);
        
        if(north == 0 && south == 0 && west == 0 && east == 0)
            setDestroy(y, x, boardEnemy, playerShoot);
    }
    
    private int checkDestroyNorth(int y,int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = y ; i >= 0 ; i--)
        {
             if(boardEnemy.getBoard(i, x) == 0)
                 return 0;
             if(boardEnemy.getBoard(i, x) == 5)
                 return 5;                          
        }
        return 0;        
    }
    private int checkDestroySouth(int y, int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = y ; i <= 9 ; i++)
        {
             if(boardEnemy.getBoard(i, x) == 0)
                 return 0;
             if(boardEnemy.getBoard(i, x) == 5)
                 return 5;                          
        }
        return 0;        
    }
    private int checkDestroyWest(int y,int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = x ; i >= 0 ; i--)
        {
             if(boardEnemy.getBoard(y, i) == 0)
                 return 0;
             if(boardEnemy.getBoard(y, i) == 5)
                 return 5;                          
        }
        return 0;        
    }    
    private int checkDestroyEast(int y, int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = x ; i <= 9 ; i++)
        {
            if(boardEnemy.getBoard(y, i) == 0)
                return 0;
            if(boardEnemy.getBoard(y, i) == 5)
                return 5;                          
        }
        return 0;        
    }        
    private void setDestroy(int y, int x, Board boardEnemy, Board playerShoot)
    {
        setDestroyNorth(y, x, boardEnemy, playerShoot);
        setDestroySouth(y, x, boardEnemy, playerShoot);        
        setDestroyWest(y, x, boardEnemy, playerShoot);
        setDestroyEast(y, x, boardEnemy, playerShoot);        
    }
    
    private void setDestroyNorth(int y, int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = y ; i >= 0 ; i--)
        {
            if(boardEnemy.getBoard(i, x) == 0)
                return;
            else
            {
                boardEnemy.setBoard(i, x, 7);
                playerShoot.setBoard(i, x, 7);
            }                         
        }   
    }   
    private void setDestroySouth(int y, int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = y ; i <= 9 ; i++)
        {
            if(boardEnemy.getBoard(i, x) == 0)
                return;
            else
            {
                boardEnemy.setBoard(i, x, 7);
                playerShoot.setBoard(i, x, 7);
            }                         
        }   
    }        
    private void setDestroyWest(int y, int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = x ; i >= 0 ; i--)
        {
            if(boardEnemy.getBoard(y, i) == 0)
                return;
            else
            {
                boardEnemy.setBoard(y, i, 7);
                playerShoot.setBoard(y, i, 7);
            }                         
        }   
    }   
    private void setDestroyEast(int y, int x, Board boardEnemy, Board playerShoot)
    {
        for(int i = x ; i <= 9 ; i++)
        {
            if(boardEnemy.getBoard(y, i) == 0)
                return;
            else
            {
                boardEnemy.setBoard(y, i, 7);
                playerShoot.setBoard(y, i, 7);
            }                           
        }   
    }            
    
    
}
