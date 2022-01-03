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
       //boardPlayer = player.startPlayerBoard(); 
       // boardAi = ai.startAiBoard();
       

   //     shootPlayer = player.playerBattle(boardAi, shootPlayer);

        boardPlayer = ai.startAiBoard();
         ai.boardAi.drawBoard();
        shootPlayer = ai.aiBattle(boardPlayer, shootPlayer);
        
        
        
        
     
    }
    
}
