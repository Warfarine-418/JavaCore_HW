package HW1;

public class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getInfoAboutJump(Creature creature) {
        return creature.jump(this);
    }
}
