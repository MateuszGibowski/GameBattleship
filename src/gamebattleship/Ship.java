package gamebattleship;


public class Ship {
    private int lenght;
    private int boat = 4;
    private int destroyer = 3;
    private int cruiser = 2;
    private int battleship = 1;
    
    
    public void setLenght(String ship)
    {
        switch (ship)
        {
            case "battleship" -> lenght = 4;
            case "cruiser" -> lenght = 3;
            case "destroyer" -> lenght = 2;
            case "boat" -> lenght = 1;            
        }   

    }
    public int getLenght()
    {
        return this.lenght;
    }
    public int getAmountShip(String ship)
    {
        if(ship.equals("battleship"))
            return battleship;
        else if(ship.equals("cruiser"))
            return cruiser;
        else if(ship.equals("destroyer"))
            return destroyer;
        else if(ship.equals("boat"))
            return boat;
        else
            return -1;
    }
    public void lessAmountShip(String ship)
    {
        switch (ship)
        {
            case "battleship" -> battleship--;
            case "cruiser" -> cruiser--;
            case "destroyer" -> destroyer--;
            case "boat" -> boat--;
        }
    }
}
