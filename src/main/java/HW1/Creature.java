package HW1;

public abstract class Creature {
    protected String name;

    public Creature(String name) {
        this.name = name;
    }

    public abstract int run(Track track);

    public abstract int jump(Wall wall);
}
