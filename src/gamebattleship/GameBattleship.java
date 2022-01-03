package gamebattleship;


public class GameBattleship {
    static Board boardAi;
    static Board boardPlayer;
    static Board shootPlayer = new Board();
    static Board shootAi = new Board();


    public static void main(String[] args) 
    {
        Player player = new Player();
        Player ai = new Player();
       // player.startPlayerBoard(); 
        boardAi = ai.startAiBoard();
        ai.boardAi.drawBoard();
        
        shootPlayer = player.Playerbattle(boardAi, shootPlayer);
     
        shootPlayer.drawBoard();
        
        
        
        
     
    }
    
}
