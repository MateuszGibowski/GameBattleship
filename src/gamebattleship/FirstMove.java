package gamebattleship;

import java.util.Random;
import java.util.Scanner;


public class FirstMove
{  
    public Scanner scanner = new Scanner(System.in);
    
    public void setBoardPlayer (Board board, Move move, Ship ship, String player)
    {
        String prov;
        String chooseShip;
        String direction;
        while(true)
        {
            chooseShip = chooseWhatPut(ship, player);
            direction = "north";
            if(player.equals("player")) 
                board.drawBoard();
            while(true)
            {
                prov = whereProv(board, move, ship, player);
                if(!(prov.equals("error")))
                    break;
            }

            int y = Character.getNumericValue(prov.charAt(0)); 
            int x = Character.getNumericValue(prov.charAt(1)); 
            if(ship.getLenght() != 1)
                direction = setDirection(y, x, board, move, ship, player);
            board.setShip(y, x, ship.getLenght(), direction);
        ship.lessAmountShip(chooseShip); 
        if(player.equals("player"))
            board.drawBoard();
        if(ship.getAmountShip("battleship") == 0 && ship.getAmountShip("cruiser") == 0 && ship.getAmountShip("destroyer") == 0 && ship.getAmountShip("boat") == 0)
            break;
        }
        System.out.println("Plansza gracza ustawiona");
    }
    
    public void startBoardAi(Board board, Move move, Ship ship, String player)
    {
        String prov;
        String chooseShip;
        String direction;
        while(true)
        {
            chooseShip = chooseWhatPut(ship, player);
            direction = "north";
          //  board.drawBoard();
            while(true)
            {
                prov = whereProv(board, move, ship, player);
                if(!(prov.equals("error")))
                    break;
            }

            int y = Character.getNumericValue(prov.charAt(0)); 
            int x = Character.getNumericValue(prov.charAt(1)); 
            if(ship.getLenght() != 1)
                direction = setDirection(y, x, board, move, ship, player);
            board.setShip(y, x, ship.getLenght(), direction);
        ship.lessAmountShip(chooseShip);       
      //  board.drawBoard();
        if(ship.getAmountShip("battleship") == 0 && ship.getAmountShip("cruiser") == 0 && ship.getAmountShip("destroyer") == 0 && ship.getAmountShip("boat") == 0)
            break;
        }   
    }
    
    
    
    
    public String chooseWhatPut(Ship ship, String player)
    {
        int battleship = ship.getAmountShip("battleship");
        int cruiser = ship.getAmountShip("cruiser");
        int destroyer = ship.getAmountShip("destroyer");
        int boat = ship.getAmountShip("boat");
        
        
        int choose;
        if(player.equals("player"))
        {
            System.out.println("Co chcesz wybrać?");
            if(battleship !=0)
                System.out.println("1 - Pancernik (4 pola)");
            if(cruiser !=0)
                System.out.println("2 - Krążownik (3 pola)");
            if(destroyer !=0)
                System.out.println("3 - Niszczyciel (2 pola)");
            if(boat !=0)
                System.out.println("4 - Kuter (1 pola)");
            System.out.println("5 - wyjście");
        }
        
        if(player.equals("ai"))
        {
            while(true)
            {
                Random rand = new Random();
                choose = rand.nextInt(4) + 1;
                if(battleship != 0 && choose == 1)
                {
                    ship.setLenght("battleship");
                    return "battleship";
                }
                if(cruiser != 0 && choose == 2)
                {
                    ship.setLenght("cruiser");
                    return "cruiser";
                }
                if(destroyer != 0 && choose == 3)
                {
                    ship.setLenght("destroyer");
                    return "destroyer";
                }
                if(boat != 0 && choose == 4)
                {
                    ship.setLenght("boat");
                    return "boat";
                }                
            }
            
        }
           
        while(true)
        {
            String what = scanner.next();
            if (what.equals("5"))
                   System.exit(0);
            if(battleship != 0 && (what.charAt(0)) == '1')
            {
                ship.setLenght("battleship");
                return "battleship";
           //     break;
            }
            if(cruiser != 0 && (what.charAt(0)) == '2')
            {
                ship.setLenght("cruiser");
                return "cruiser";
         //       break;
            }
            if(destroyer != 0 && (what.charAt(0)) == '3')
            {
                ship.setLenght("destroyer");
                return "destroyer";
               // break;
            }          
            if(boat != 0 && (what.charAt(0)) == '4')
            {
                ship.setLenght("boat");
                return "boat";
                //break;
            }            
        
            System.out.println("Błędny wybór");
        }
        
    }
    

    
    private String setDirection(int y, int x, Board board, Move move, Ship ship, String player)
    {
        int north = checkDirection(y, x, board, move, ship, "north");
        int south = checkDirection(y, x, board, move, ship, "south");       
        int west = checkDirection(y, x, board, move, ship, "west");
        int east = checkDirection(y, x, board, move, ship, "east");
        int choose;
        
        if(player.equals("ai"))
        {
            Random rand = new Random();
            while(true)
            {
                choose = rand.nextInt(4) + 1;
                if(north == 0 && choose == 1)
                    return "north";
                if(south == 0 && choose == 2)
                    return "south";
                if(west == 0 && choose == 3)
                    return "west";
                if(east == 0 && choose == 4)
                    return "east";  
            } 
        }

        while(true)
        {
            System.out.println("W jakim kierunku chcesz ustawić okręt?");
            if(north == 0)
                System.out.println("1 - północ");
            if(south == 0)
                System.out.println("2 - południe");
            if(west == 0)
                System.out.println("3 - zachódd");
            if(east == 0)
                System.out.println("4 - wschód");

            String what = scanner.next();
            if(north == 0 && (what.charAt(0)) == '1')
            {
                return "north";
            }
            if(south == 0 && (what.charAt(0)) == '2')
            {
                return "south";
            }
            if(west == 0 && (what.charAt(0)) == '3')
            {
                return "west";
            }         
            if(east == 0 && (what.charAt(0)) == '4')
            {
                return "east";
            }  
        System.out.println("Błędny wybór");
        }
    }
    
    public String convert(String field)
    {
        if(field.length()<2)
            return "error";
        char scanCharY = field.charAt(0);
        char scanCharX = field.charAt(1);      
        String x, y;

        if(scanCharY == 'A' || scanCharY == 'a') y = "0";
        else if(scanCharY == 'B' || scanCharY == 'b') y = "1";
        else if(scanCharY == 'C' || scanCharY == 'c') y = "2";
        else if(scanCharY == 'D' || scanCharY == 'd') y = "3";
        else if(scanCharY == 'E' || scanCharY == 'e') y = "4";
        else if(scanCharY == 'F' || scanCharY == 'f') y = "5";
        else if(scanCharY == 'G' || scanCharY == 'g') y = "6";
        else if(scanCharY == 'H' || scanCharY == 'h') y = "7";
        else if(scanCharY == 'I' || scanCharY == 'i') y = "8";
        else if(scanCharY == 'J' || scanCharY == 'j') y = "9";
        else 
        {
            return "error";
        }
        if(scanCharX == '0') x = "0";
        else if(scanCharX == '1') x = "1";
        else if(scanCharX == '2') x = "2";
        else if(scanCharX == '3') x = "3";
        else if(scanCharX == '4') x = "4";
        else if(scanCharX == '5') x = "5";
        else if(scanCharX == '6') x = "6";
        else if(scanCharX == '7') x = "7";
        else if(scanCharX == '8') x = "8";
        else if(scanCharX == '9') x = "9";
        else 
        {
            return "error";
        }
        return y+x;    
    }
    
    public String whereProv(Board board, Move move, Ship ship, String player)
    {
        int x, y;
        Random rand = new Random();
        
        if(player.equals("ai"))
        {
            y = rand.nextInt(10);
            x = rand.nextInt(10);
            
            if(checkProv(y, x, board, move, ship) == 1)
            {
                if(player.equals("player"))
                    System.out.println("Błędna wartość");
                return "error";
            }         
        return String.valueOf(y)+String.valueOf(x);    
        }
            
            
            
        System.out.println("Gdzie chcesz ułożyć dziub statku?");
        while(true)
        {
            String chooseField = scanner.next();
            chooseField = convert(chooseField);
            if(chooseField.equals("error"))
            System.out.println("Błędna wartość");
            else
            {
                y = Character.getNumericValue(chooseField.charAt(0)); 
                x = Character.getNumericValue(chooseField.charAt(1));               
                break;
            }
        }

        if(checkProv(y, x, board, move, ship) == 1)
        {
            if(player.equals("player"))
                System.out.println("Błędna wartość");
            return "error";
        }
        return String.valueOf(y)+String.valueOf(x);
    }
           
    private int checkProv(int y, int x, Board board, Move move, Ship ship)  
    {
        int i;

        if(board.getBoard(y, x) != 0)
            return 1;
        if(checkNeighbour(y, x, board, move) == 1)
            return 1;

        int north = checkDirection(y, x, board, move, ship, "north");
        int south = checkDirection(y, x, board, move, ship, "south");
        int west = checkDirection(y, x, board, move, ship, "west");
        int east = checkDirection(y, x, board, move, ship, "east");
        if(north == 1 && south == 1 && west == 1 && east == 1)
            return 1;
       
 
            return 0;  
    }
   
    private int checkNeighbour(int y, int x, Board bord, Move move)
    {
        if(move.checkDirection(y, x, "north") > 0)
           return 1;
        if(move.checkDirection(y, x, "south") > 0)
            return 1;
        if(move.checkDirection(y, x, "west") > 0)
           return 1;
        if(move.checkDirection(y, x, "east") > 0)
           return 1;
        
        return 0;
    }
    
    private int checkDirection(int y, int x, Board board, Move move, Ship ship, String direction)
    { 
        if(direction.equals("north") || direction.equals("south"))
        {
            if(move.checkDirection(y, x, ship.getLenght(), direction) != 0)
                return 1;
            if(move.checkDirection(y, x-1, ship.getLenght(), direction) > 0)
                return 1;     
            if(move.checkDirection(y, x+1, ship.getLenght(), direction) > 0)
                return 1;
            if(direction.equals("north"))
            {
                if(move.checkDirection(y-(ship.getLenght()-1), x, "north") > 0)
                    return 1;
            }
            else
                if(move.checkDirection(y+(ship.getLenght()-1), x, "south") > 0)
                    return 1;
        }
        if(direction.equals("west") || direction.equals("east"))
        {
            if(move.checkDirection(y, x, ship.getLenght(), direction) != 0)
                return 1;
            if(move.checkDirection(y-1, x, ship.getLenght(), direction) > 0)
                return 1;     
            if(move.checkDirection(y+1, x, ship.getLenght(), direction) > 0)
                    return 1; 
            if(direction.equals("west"))
            {
                if(move.checkDirection(y, x-(ship.getLenght()-1), "west") > 0)
                    return 1;
            }
            else
            {
                if(move.checkDirection(y, x+(ship.getLenght()-1), "east") > 0)
                    return 1;    
            }
        }        
       
        return 0;
    }
  
    
    
}
