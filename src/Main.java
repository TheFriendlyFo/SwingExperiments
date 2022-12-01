public class Main {
    public static void main(String[] args) {
        Player player = new Player(0,0);
        Maze maze = new Maze(30,30,player);

        Frame frame = new Frame(maze, player);

        Panel panel = new Panel(maze, player);
        frame.add(panel);
        frame.pack();


    }
}
