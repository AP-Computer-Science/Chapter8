//********************************************************************
//  Maze.java       Author: Lewis/Loftus/Cocking
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

public class Maze3D
{
   private final int TRIED = 3;
   private final int PATH = 7;

   private int[][][] grid = new int[5][8][1];
   public Maze3D() {
       for(int r = 0; r < grid.length; r++)
           for(int c = 0; c < grid[0].length; r++)
               for(int l = 0; l < grid[0][0].length; l++) {
                   grid[r][c][l] = (int)(Math.random() * 2);
               }
   }

   //-----------------------------------------------------------------
   //  Tries to recursively follow the maze. Inserts special
   //  characters for locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column, int level)
   {
      boolean done = false;

      if (valid (row, column, level))
      {
         grid[row][column][level] = TRIED; // this cell has been tried

         if (row == grid.length-1 && column == grid[0].length-1 && level == grid[0][0].length - 1)
            done = true; // the maze is solved
         else
         {
            done = traverse (row+1, column, level);     // down
            if (!done)
               done = traverse (row, column+1, level);  // right
            if (!done)
               done = traverse (row-1, column, level);  // up
            if (!done)
               done = traverse (row, column-1, level);  // left
            if (!done) {
                done = traverse(row, column, level - 1); // Down a level
            }
         }
         
         if (done)  // this location is part of the final path
            grid[row][column][level] = PATH;
         }

         return done;
   }

   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column, int level)
   {
      boolean result = false;

      //  check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length &&
          level >= 0 && level < grid[row][column].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column][level] == 1)
            result = true;

      return result;
   }

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++) {
            for(int level=0; level < grid[row][column].length; level++) {
                result += grid[row][column][level] + "";
            }
         }
         result += "\n";
      }

      return result;
   }
}