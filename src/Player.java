public class Player {
    private int x,y;

    /**
     * Represents a player, keeping track of their coordinates as int x and int y.
     * @param x The player's distance moving right from the maze's origin (0,0)
     * @param y The player's distance moving down from the maze's origin (0,0)
     */
    Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Represents a player, keeping track of their coordinates as int x and int y.
     * x and y are initialized as 0.
     */
    Player() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * @return Returns the player's current x value.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Returns the player's current y value.
     */
    public int getY() {
        return y;
    }

    /**
     * Increases the player's current x value by inc.
     * Inc is either -1 or 1;
     * @param inc the amount the player's x value is to be increased by.
     */
    public void incX(int inc) {
        x += inc;
    }

    /**
     * Increases the player's current y value by inc.
     * Inc is either -1 or 1;
     * @param inc the amount the player's y value is to be increased by.
     */
    public void incY(int inc) {
        y += inc;
    }
}
