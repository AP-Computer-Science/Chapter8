//********************************************************************
//  MazeSearch.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates recursion.
//********************************************************************
public class MazeSearchNoSave
{
   //-----------------------------------------------------------------
   //  Creates a new maze, prints its original form, tries to
   //  solve it, and prints out its final form.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
   
      MazeNoSave labyrinth = new MazeNoSave(10, 10);
       System.out.println(labyrinth);
      if(labyrinth.traverse(0, 0)) {
          System.out.println("Found solution.");
      }
   }
}