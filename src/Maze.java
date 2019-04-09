//********************************************************************
//  Maze.java       Author: Lewis/Loftus/Cocking
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

public class Maze
{
   private final String TRIED = "\u20DD";
   private final String PATH = "\u235F";

   private String[][] grid;
   public Maze(int ar, int ac) {
       grid = new String[ar][ac];
       for(int r = 0; r < grid.length; r++) {
           for(int c = 0; c < grid[0].length; c++) {
               grid[r][c] = ((int)(Math.random() * 2) == 0) ? "\u25a0" : "\u25a1";
           }
       }
   }

   //-----------------------------------------------------------------
   //  Tries to recursively follow the maze. Inserts special
   //  characters for locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column)
   {
      boolean done = false;

      if (valid (row, column))
      {
         grid[row][column] = TRIED; // this cell has been tried

         if (row == grid.length-1 && column == grid[0].length-1)
            done = true; // the maze is solved
         else
         {
            done = traverse (row+1, column);     // down
            if (!done)
               done = traverse (row, column+1);  // right
            if (!done)
               done = traverse (row-1, column);  // up
            if (!done)
               done = traverse (row, column-1);  // left
         }
         
         if (done)  // this location is part of the final path
            grid[row][column] = PATH;
         }

         return done;
   }

   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;

      //  check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == "\u25a1")
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
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }
}