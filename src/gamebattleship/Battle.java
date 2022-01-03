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

    }
    
    void checkDestroyNorth()
    {
        
    }
    
    
}
