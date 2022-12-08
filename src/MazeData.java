import java.util.ArrayList;
import java.util.Stack;

public class MazeData {
    private record Vector(int inX, int inY, int inWall, int outWall) {
    }
    private final Cell[][] cells;
    private final int height, width;

    MazeData(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
        generateMaze();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean isAccessible(int x, int y, int wall) {
        return !cells[y][x].getWall(wall);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void setUpCells() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                cells[row][column] = new Cell(column, row);
            }
        }
    }

    private boolean inBounds(int x, int y) {
        boolean xInBounds = (x >= 0 && x < width);
        boolean yInBounds = (y >= 0 && y < height);
        return xInBounds && yInBounds;
    }

    public void generateMaze() {
        setUpCells();

        Stack<Cell> path = new Stack<>();
        int accessedCells = 1;
        Cell currentCell = cells[0][0];
        ArrayList<Vector> possibilities = new ArrayList<>();

        while (accessedCells < height * width) {
            possibilities.clear();
            for (int[] direction : new int[][]{{0, 1, 0}, {-1, 0, 1}, {1, 0, 2}, {0, -1, 3}}) {
                // Gets the coordinates of the new cell:
                int newX = currentCell.getX() + direction[0];
                int newY = currentCell.getY() + direction[1];
                // Checks if the cell is in bounds and hasn't been visited:
                if (inBounds(newX, newY) && !cells[newY][newX].isAccessed()) {
                    // Adds the new cell to the list of possibilities for this iteration:
                    possibilities.add(new Vector(newX, newY, 3 - direction[2], direction[2]));
                }
            }
            // If there's at least one valid unvisited cell:
            if (possibilities.size() > 0) {
                // Selects a new cell randomly from the ones found:
                Vector vector = possibilities.get((int) (Math.random() * possibilities.size()));
                // Lowers the wall of the old cell:
                currentCell.lowerWall(vector.outWall());
                // Centers onto the new cell:
                currentCell = cells[vector.inY()][vector.inX()];
                // Lowers the wall of the new cell:
                currentCell.lowerWall(vector.inWall());
                // Adds the new cell to the stack:
                path.push(currentCell);
                accessedCells++;
            } else {
                currentCell = path.pop();
            }
        }
    }
}