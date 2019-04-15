
public class Maze3DTester {
    public static void main(String[] args) {
        int counter = 0;
        while(true) {
            Maze3D labyrinth = new Maze3D(5, 5, 3);
            if(labyrinth.traverse(0, 0, 0)) {
                System.out.println("Success. Count: " + counter);
                System.out.println(labyrinth);
                break;
            }
            else {
                counter++;
            }
        }
    }
}
