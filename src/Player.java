public class Player {
    private int x,y;

    Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Player() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incX(boolean inc) {
        x += inc ? 1 : -1;
    }

    public void incY(boolean inc) {
        y += inc ? 1 : -1;
    }
}
