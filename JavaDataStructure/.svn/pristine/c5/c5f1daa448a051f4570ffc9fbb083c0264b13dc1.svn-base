package edu.colorado.ch13.extension;
import java.util.Vector;

public class Connect4 extends AbstractGame implements Cloneable
{
   public static final int ROWS = 6;
   public static final int COLUMNS = 7;
   public static final int DEPTH = 4;
   
   //Added by James ZOU
   public static final int HUMAN = Player.human.ordinal();
   public static final int COMPUTER = Player.computer.ordinal();
   public static final int NEUTRAL = Player.nobody.ordinal();
     
   // Private static member constants, defined here.
   // The FOUR_VALUE is the value returned by
   // the value function when it finds four-in-a-row. For the current
   // implementation of evaluate to work, the FOUR_VALUE should be at least
   // 24 times as large as the total number of spots on the board.
   // MOVE_STRINGS is an array of all possible moves, which must be strings
   // corresponding to the integers 0 through COLUMNS-1.
   private static final int FOUR_VALUE = 24*ROWS*COLUMNS;
   private static final String[ ] MOVE_STRINGS =
      {"0", "1", "2", "3", "4", "5", "6"};

   private Player[ ][ ] data = new Player[ROWS][COLUMNS];
   private int[ ] manyUsed = new int[COLUMNS];
   private int mostRecentColumn;

   public static void main(String[ ] args)
   {
      repeatPlay("edu.colorado.games.Connect4", DEPTH);
   }

   protected Connect4 clone( )
   {
      Connect4 answer;
      int i;

      try
      {
         answer = (Connect4) super.clone( );
      }
      catch (Exception e)
      {
         throw new RuntimeException
         ("This class does not implement Cloneable.");
      }

      // Make new copies of the data and manyUsed arrays:
      answer.manyUsed = manyUsed.clone( );
      answer.data = data.clone( );
      for (i = 0; i < ROWS; i++)
         answer.data[i] = data[i].clone( );

      return answer;
   }

   protected Vector<String> computeMoves( )
   {
      Vector<String> moves = new Vector<String>( );
      int i;
	
      for (i = 0; i < COLUMNS; i++)
      {
          if (manyUsed[i] < ROWS)
              moves.addElement(MOVE_STRINGS[i]);
      }

      return moves;
   }

   protected void displayStatus( )
   {
      int row, column;

      System.out.println("\nCurrent game status");
      System.out.println("(HUMAN = #  and  COMPUTER = @):");
      if (movesCompleted( ) != 0)
         System.out.println("Most recent move in column " + mostRecentColumn);
      for (row = ROWS-1; row >= 0; --row)
      {
         for (column = 0; column < COLUMNS; ++column)
         {
             switch (data[row][column])
             {
             case human:    System.out.print("  #"); break;
             case computer: System.out.print("  @"); break;
             case nobody:   System.out.print("  ."); break;
             }
         }
         System.out.println( );
      }
      for (column = 0; column < COLUMNS; ++column)
         System.out.printf("%3d", column);
      if (isGameOver( ))
         System.out.println("\nGame over.");
      else if (nextMover( ) == Player.human)
         System.out.println("\nHuman's turn (please type a column number)");
      else
         System.out.println("\nComputer's turn to move (please wait)...");
   }

   protected double evaluate( )
   {
      // NOTE: Positive answer is good for the computer.
      int row, column;
      int answer = 0;

      // For each possible starting spot, calculate the value of the spot for
      // a potential four-in-a-row, heading down, left, and to the lower-left.
      // Normally, this value is in the range [-3...+3], but if a
      // four-in-a-row is found for the player, the result is FOUR_VALUE which
      // is large enough to make the total answer larger than any evaluation
      // that occurs with no four-in-a-row.

      // Value moving down from each spot:
      for (row = 3; row < ROWS; ++row)
         for (column = 0; column < COLUMNS; ++column)
            answer += value(row, column, -1, 0);

      // Value moving left from each spot:
      for (row = 0; row < ROWS; ++row)
         for (column = 3; column < COLUMNS; ++column)
            answer += value(row, column, 0, -1);

      // Value heading diagonal (lower-left) from each spot:
      for (row = 3; row < ROWS; ++row)
         for (column = 3; column < COLUMNS; ++column)
            answer += value(row, column, -1, -1);

      // Value heading diagonal (lower-right) from each spot:
      for (row = 3; row < ROWS; ++row)
         for (column = 0; column <= COLUMNS-4; ++column)
            answer += value(row, column, -1, +1);

      return answer;
   }

   protected boolean isGameOver( )
   {         
      int row, column;
      int i;
	
      // Two simple cases:    
      if (movesCompleted( ) == 0)
         return false;
      if (movesCompleted( ) == ROWS*COLUMNS)
         return true;

      // Check whether most recent move is part of a four-in-a-row
      // for the player who just moved.
      column = mostRecentColumn;
      row = manyUsed[column] - 1;
      // Vertical:
      if (Math.abs(value(row, column, -1, 0)) == FOUR_VALUE) return true;
      for (i = 0; i <= 3; i++)
      {
         // Diagonal to the upper-right:
         if (Math.abs(value(row-i, column-i, 1,  1)) == FOUR_VALUE) return true;
         // Diagonal to the lower-right:
         if (Math.abs(value(row-i, column+i, 1, -1)) == FOUR_VALUE) return true;
         // Horizontal:
         if (Math.abs(value(row,   column-i, 0,  1)) == FOUR_VALUE) return true;
      }

      return false;
   }

   protected boolean isLegal(String move)
   {
      int column;

      try
      {
         column = Integer.valueOf(move).intValue( );
      }
      catch (NumberFormatException e)
      {
         return false;
      }

      return
         (!isGameOver( ))
         &&
         (column < COLUMNS)
         &&
         (manyUsed[column] < ROWS);
   }

   protected void makeMove(String move)
   {
      int row, column;
	
      super.makeMove(move);
      column = Integer.valueOf(move).intValue( );
      row = manyUsed[column]++;
      data[row][column] = nextMover( );
      mostRecentColumn = column;
   }

   private int value(int row, int column, int deltar, int deltac)
   {
      // NOTE: Positive return value is good for the computer.    
      int i;
      int endRow = row + 3*deltar;
      int endColumn = column + 3*deltac;
      int playerCount= 0;
      int opponentCount = 0;

      if (
         (row < 0) || (column < 0) || (endRow < 0) || (endColumn < 0)
         ||
         (row >= ROWS) || (endRow >= ROWS)
         ||   
         (column >= COLUMNS) || (endColumn >= COLUMNS)
         )
	    return 0;

      for (i = 1; i <= 4; ++i)
      {
         if (data[row][column] == Player.computer)
             ++playerCount;
         else if (data[row][column] != Player.nobody)
             ++opponentCount;
         row += deltar;
         column += deltac;
      }

      if ((playerCount > 0) && (opponentCount > 0))
         return 0; // Neither player can get four-in-a-row here.
      else if (playerCount == 4)
         return FOUR_VALUE;
      else if (opponentCount == 4)
         return -FOUR_VALUE;
      else
         return playerCount - opponentCount;
   }


}
