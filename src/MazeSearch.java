//********************************************************************
//  MazeSearch.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates recursion.
//********************************************************************
public class MazeSearch
{
   //-----------------------------------------------------------------
   //  Creates a new maze, prints its original form, tries to
   //  solve it, and prints out its final form.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      Maze labyrinth = new Maze(10, 20);
   
      int counter = 0;
      while(!labyrinth.traverse(0, 0)) {
          counter++;
          labyrinth = new Maze(10, 20);
      }
      System.out.println("Found solution. Attempts: " + counter);
      System.out.println(labyrinth);

   }
}