import java.util.ArrayList;
import java.util.Stack;

public class Maze {
    private record Vertex(int inX, int inY, int inWall, int outWall) {
    }
    private final Cell[][] cells;
    private final int height, width;

    Maze(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
        setUpCells();
        generateMaze();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean isAccessible(int x, int y, int wall) {
        return !cells[y][x].getWall(wall);
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

    private void generateMaze() {
        Stack<Cell> path = new Stack<>();
        int accessedCells = 1;
        Cell currentCell = cells[0][0];
        ArrayList<Vertex> possibilities = new ArrayList<>();

        while (accessedCells < height * width) {
            possibilities.clear();
            for (int[] direction : new int[][]{{0, 1, 0}, {-1, 0, 1}, {1, 0, 2}, {0, -1, 3}}) {
                // Gets the coordinates of the new cell:
                int newX = currentCell.getX() + direction[0];
                int newY = currentCell.getY() + direction[1];
                // Checks if the cell is in bounds and hasn't been visited:
                if (inBounds(newX, newY) && !cells[newY][newX].isAccessed()) {
                    // Adds the new cell to the list of possibilities for this iteration:
                    possibilities.add(new Vertex(newX, newY, 3 - direction[2], direction[2]));
                }
            }
            // If there's at least one valid unvisited cell:
            if (possibilities.size() > 0) {
                // Selects a new cell randomly from the ones found:
                Vertex vertex = possibilities.get((int) (Math.random() * possibilities.size()));
                // Lowers the wall of the old cell:
                currentCell.lowerWall(vertex.outWall());
                // Centers onto the new cell:
                currentCell = cells[vertex.inY()][vertex.inX()];
                // Lowers the wall of the new cell:
                currentCell.lowerWall(vertex.inWall());
                // Adds the new cell to the stack:
                path.push(currentCell);
                accessedCells++;
            } else {
                currentCell = path.pop();
            }
        }
    }
}