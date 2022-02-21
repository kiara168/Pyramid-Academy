/**
 * The Entity stores information about the UTF char
 * and the position in the world
 */

public class Entity {
    char type;
    private int x;
    private int y;

    public Entity(int x, int y, char type) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * the entity is just the UTF char as a String
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(type);
    }

}
