public class Main {
    public static void main(String[] args) {
        MazeData maze = new MazeData(17,17);

        Player player1 = new Player();
        Player player2 = new Player();

        DisplayPanel leftPanel = new DisplayPanel(maze, player1, 50);
        DisplayPanel rightPanel = new DisplayPanel(maze, player2, 50);

        Frame frame = new Frame(leftPanel, rightPanel);
    }
}
