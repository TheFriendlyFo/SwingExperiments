/**
 * @param outWall Out represents the outgoing cell, the cell being left behind.
 * @param inX     In represents the ingoing cell, the cell being entered.
 */
public record Vertex(int inX, int inY, int inWall, int outWall) {
}
