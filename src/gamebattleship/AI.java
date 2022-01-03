package gamebattleship;


public class AI {
  FirstMove firstMove = new FirstMove();
   Board board = new Board();
   Move move = new Move(board);
   Ship ship = new Ship();
   
   public void startBoard()
   { 
        firstMove.startBoardAi(board, move, ship, "ai");
        board.drawBoard(); 
   }

}