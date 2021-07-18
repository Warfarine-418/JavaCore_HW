package HW1;

public class Cat extends Creature {
    private static final int maxRunCatDis = 400;
    private static final int maxJumpCatHei = 18;

    public Cat(String name) {
        super(name);
    }

    public static int getMaxRunCatDis() {
        return maxRunCatDis;
    }

    public static int getMaxJumpCatHei() {
        return maxJumpCatHei;
    }

    @Override
    public int run(Track track) {
        if (track.getDistance() > maxRunCatDis) {
            System.out.println(this.name + " не может пробежать такую дистанцию.");
        } else System.out.println(this.name + " пробежал " + track.getDistance() + " м.");
        return 0;
    }

    @Override
    public int jump(Wall wall) {
        if (wall.getHeight() > maxJumpCatHei) {
            System.out.println(this.name + " не может прыгнуть так высоко.");
        } else System.out.println(this.name + " прыгнул на " + wall.getHeight() + " м.");
        return 0;
    }
}
