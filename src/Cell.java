public class Cell {
    /*Walls are as follows:
     * / 3 \
     * 1   2
     * \ 0 /
     */
    private final boolean[] walls;
    private boolean accessed;
    private final int x, y;

    Cell(int x, int y){
        this.x = x;
        this.y = y;
        walls = new boolean[]{true, true, true, true};
        accessed = false;
    }

    public void lowerWall(int wall) {
        walls[wall] = false;
        accessed = true;
    }

    public boolean isAccessed() {
        return accessed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getWall(int wall) {
        return walls[wall];
    }
}
