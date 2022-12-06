public class Main {
    public static void main(String[] args) {
        MazeData maze = new MazeData(13,13);

        Player player1 = new Player();
        Player player2 = new Player();

        DisplayPanel leftPanel = new DisplayPanel(maze, player1, 100);
        DisplayPanel rightPanel = new DisplayPanel(maze, player1, 100);

        Frame frame = new Frame(leftPanel, rightPanel);
    }
}
