package gamebattleship;


public class Player {
    FirstMove firstMovePlayer = new FirstMove();
    Board boardPlayer = new Board();
    Move movePlayer = new Move(boardPlayer);
    Ship shipPlayer = new Ship();
    Battle battlePlayer = new Battle();
   
    FirstMove firstMoveAi = new FirstMove();
    Board boardAi = new Board();
    Move moveAi = new Move(boardAi);
    Ship shipAi = new Ship();
    Battle battleAi = new Battle();
    Board shoott;
  
   
    Board startPlayerBoard()
    { 
        firstMovePlayer.setBoardPlayer(boardPlayer, movePlayer, shipPlayer, "player");
        boardPlayer.drawBoard(); 
        return boardPlayer;
    }
    Board startAiBoard()
    { 
        firstMoveAi.startBoardAi(boardAi, moveAi, shipAi, "ai");
      //  boardAi.drawBoard();
      return boardAi;
    }



    Board playerBattle(Board boardAi, Board shoot)
    {
       shoot = battlePlayer.shoot(boardAi, movePlayer, "player", shoot);
      
      return shoot;
    }
    
    Board aiBattle(Board boardAi, Board shoot)
    {
       shoot = battleAi.shoot(boardAi, movePlayer, "ai", shoot);
      
      return shoot;
    }    

}
